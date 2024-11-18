package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.PaginationResponse;
import com.ess.recruitment.core.resp.RecruitmentCountResponse;
import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.CandidateSubmissionRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {


    @Autowired
    private CandidateSubmissionRepository candidateRepository;

    @Autowired
    private MapperConfig mapperConfig;

    private <T> PaginationResponse<T> createPaginationResponse(Page<T> page) {
        return new PaginationResponse<>(

                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getSize(),
                page.getContent()
        );
    }

    @Override
    @Transactional
    public ApiResponse createCandidate(RecruitmentRequest recruitmentRequest) {
        try {
            Optional<CandidateSubmissionEntity> latestCandidate = candidateRepository.findTopByOrderByCandidateCodeDesc();
            String candidateCode = latestCandidate
                    .map(candidate -> {
                        String latestCode = candidate.getCandidateCode().substring(4);
                        int nextCodeNumber = Integer.parseInt(latestCode) + 1;
                        return "CAN-" + String.format("%03d", nextCodeNumber);
                    })
                    .orElse("CAN-001");
            CandidateSubmissionEntity candidateSubmissionEntity =
                    mapperConfig.toCandidateEntity(recruitmentRequest.getCandidateSubmissionDto());
            candidateSubmissionEntity.setCandidateCode(candidateCode);
            CandidateSubmissionEntity savedEntity = candidateRepository.save(candidateSubmissionEntity);
            return new ApiResponse(true,"Candidate created successfully",savedEntity);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create job: " + e.getMessage());
        }
        }

    @Override
    @Transactional
    public ApiResponse getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .map(candidateSubmissionEntity -> new ApiResponse(true,"candidate found",mapperConfig.toCandidateDTO(candidateSubmissionEntity),null))
                .orElseThrow(() -> new EntityNotFoundException("Candidate with ID " + id + " not found"));
    }

    @Override
    @Transactional
    public ApiResponse getAllCandidatesWithCounts() {
        long activeCount = candidateRepository.countByDelFlag(1);
        long inactiveCount = candidateRepository.countByDelFlag(0);

        long yetToStartCount = candidateRepository.countByStatus(Status.YET_TO_START);
        long onGoingCount = candidateRepository.countByStatus(Status.ONGOING);
        long openCount = candidateRepository.countByStatus(Status.ACTIVE);
       //long closedCount = candidateRepository.countByStatus(Status.IN_ACTIVE);
        long completeCount = candidateRepository.countByStatus(Status.COMPLETE);

        activeCount=yetToStartCount+openCount+onGoingCount;
        inactiveCount=completeCount;

        long totalCount = candidateRepository.count();

        RecruitmentCountResponse response = new RecruitmentCountResponse(
                totalCount,activeCount,inactiveCount,openCount,yetToStartCount,onGoingCount,completeCount);

        return new ApiResponse(true,"getting all canditate",response,null);
    }

    @Override
    @Transactional
    public ApiResponse updateCandidateStatus(Long id, RecruitmentRequest recruitmentRequest) {
        Optional<CandidateSubmissionEntity> optionalCand = candidateRepository.findById(id);
        if (optionalCand.isPresent()) {
            CandidateSubmissionEntity existingCandidate = optionalCand.get();
            CandidateSubmissionDto candidateDto = recruitmentRequest.getCandidateSubmissionDto();

            if (candidateDto.getCandidateCode() != null) {
                existingCandidate.setCandidateCode(candidateDto.getCandidateCode());
            }
            if (candidateDto.getJobId() != null) {
                existingCandidate.setJobId(candidateDto.getJobId());
            }
            if (candidateDto.getFirstName() != null) {
                existingCandidate.setFirstName(candidateDto.getFirstName());
            }
            if (candidateDto.getMiddleName() != null) {
                existingCandidate.setMiddleName(candidateDto.getMiddleName());
            }
            if (candidateDto.getLastName() != null) {
                existingCandidate.setLastName(candidateDto.getLastName());
            }
            if (candidateDto.getEmail() != null) {
                existingCandidate.setEmail(candidateDto.getEmail());
            }
            if (candidateDto.getMobile() != null) {
                existingCandidate.setMobile(candidateDto.getMobile());
            }
            if (candidateDto.getAddress() != null) {
                existingCandidate.setAddress(candidateDto.getAddress());
            }
            if (candidateDto.getCity() != null) {
                existingCandidate.setCity(candidateDto.getCity());
            }
            if (candidateDto.getZip() != null) {
                existingCandidate.setZip(candidateDto.getZip());
            }
            if (candidateDto.getState() != null) {
                existingCandidate.setState(candidateDto.getState());
            }
            if (candidateDto.getCurrentLocation() != null) {
                existingCandidate.setCurrentLocation(candidateDto.getCurrentLocation());
            }
            if (candidateDto.getTotalExperience() != null) {
                existingCandidate.setTotalExperience(candidateDto.getTotalExperience());
            }
            if (candidateDto.getRelevantExperience() != null) {
                existingCandidate.setRelevantExperience(candidateDto.getRelevantExperience());
            }
            if (candidateDto.getNoticePeriod() != null) {
                existingCandidate.setNoticePeriod(candidateDto.getNoticePeriod());
            }
            if (candidateDto.getCurrentOrganization() != null) {
                existingCandidate.setCurrentOrganization(candidateDto.getCurrentOrganization());
            }
            if (candidateDto.getExpectedCtc() != null) {
                existingCandidate.setExpectedCtc(candidateDto.getExpectedCtc());
            }
            if (candidateDto.getRate() != null) {
                existingCandidate.setRate(candidateDto.getRate());
            }
            if (candidateDto.getCtcType() != null) {
                existingCandidate.setCtcType(candidateDto.getCtcType());
            }
            if (candidateDto.getLinkedInUrl() != null) {
                existingCandidate.setLinkedInUrl(candidateDto.getLinkedInUrl());
            }
            if (candidateDto.getAlternateContactNumber() != null) {
                existingCandidate.setAlternateContactNumber(candidateDto.getAlternateContactNumber());
            }
            if (candidateDto.getWorkAuthorization() != null) {
                existingCandidate.setWorkAuthorization(candidateDto.getWorkAuthorization());
            }
            if (candidateDto.getWillingToRelocate() != null) {
                existingCandidate.setWillingToRelocate(candidateDto.getWillingToRelocate());
            }
            if (candidateDto.getWorkedWithClient() != null) {
                existingCandidate.setWorkedWithClient(candidateDto.getWorkedWithClient());
            }
            if (candidateDto.getClientDetails() != null) {
                existingCandidate.setClientDetails(candidateDto.getClientDetails());
            }
            if (candidateDto.getCommunicationSkills() != null) {
                existingCandidate.setCommunicationSkills(candidateDto.getCommunicationSkills());
            }
            if (candidateDto.getDegree() != null) {
                existingCandidate.setDegree(candidateDto.getDegree());
            }
            if (candidateDto.getUniversity() != null) {
                existingCandidate.setUniversity(candidateDto.getUniversity());
            }
            if (candidateDto.getYearOfPassed() != null) {
                existingCandidate.setYearOfPassed(candidateDto.getYearOfPassed());
            }
            if (candidateDto.getCountry() != null) {
                existingCandidate.setCountry(candidateDto.getCountry());
            }
            if (candidateDto.getConsent() != null) {
                existingCandidate.setConsent(candidateDto.getConsent());
            }
            if (candidateDto.getResumeFile() != null) {
                existingCandidate.setResumeFile(candidateDto.getResumeFile());
            }
            if (candidateDto.getIdProofFile() != null) {
                existingCandidate.setIdProofFile(candidateDto.getIdProofFile());
            }

            CandidateSubmissionEntity updatedEntity = candidateRepository.save(existingCandidate);

            return new ApiResponse(true,"canditate updated success",mapperConfig.toCandidateDTO(updatedEntity),null);
        } else {
            throw new EntityNotFoundException("Candidate with ID " + id + " not found");
        }
    }

    @Override
    @Transactional
    public ApiResponse softDeleteCandidate(Long candidateId) {
        Optional<CandidateSubmissionEntity> candidateSubmissionEntityOptional = candidateRepository.findById(candidateId);
        if (candidateSubmissionEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Candidate not found with ID: " + candidateId);
        }
        candidateRepository.softDeleteCandidate( candidateId);
        return new ApiResponse(true,"soft delete success",null,null);
    }

    @Override
    @Transactional
    public ApiResponse getAllCandidates(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CandidateSubmissionEntity> candidatePage = candidateRepository.findAll(pageable);
        List<CandidateSubmissionDto> candidates = candidatePage.getContent().stream()
                .map(mapperConfig::toCandidateDTO)
                .collect(Collectors.toList());

        PaginationResponse<CandidateSubmissionDto> paginationResponse = new PaginationResponse<>(
                candidatePage.getTotalPages(),
                candidatePage.getNumber(),
                candidatePage.getTotalElements(),
                candidatePage.getSize(),
                candidates
        );
        return new ApiResponse(true,"candidates retrieve succes",null);
    }

    @Override
    @Transactional
    public ApiResponse globalSearch(String searchKey, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CandidateSubmissionEntity> candidateSubmissionEntities = candidateRepository.globalSearch(searchKey, pageable);

        List<CandidateSubmissionDto> candidateSubmissionDtoList = candidateSubmissionEntities.getContent().stream()
                .map(mapperConfig::toCandidateDTO)
                .collect(Collectors.toList());

        PaginationResponse<CandidateSubmissionDto> paginationResponse = new PaginationResponse<>(
                candidateSubmissionEntities.getTotalPages(),
                candidateSubmissionEntities.getNumber(),
                candidateSubmissionEntities.getTotalElements(),
                candidateSubmissionEntities.getSize(),
                candidateSubmissionDtoList
        );

        if (candidateSubmissionDtoList.isEmpty()) {
            return new ApiResponse(true,"canditates",null);
        }

        return new ApiResponse(true,"candidates",null);
    }
}
