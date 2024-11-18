package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.PaginationResponse;
import com.ess.recruitment.core.resp.RecruitmentCountResponse;
import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.InterviewEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.InterviewRepository;
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
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    MapperConfig mapperConfig;

    @Autowired
    InterviewRepository interviewRepository;
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
    public ApiResponse createInterivew(RecruitmentRequest recruitmentRequest) {
        try {
            Optional<InterviewEntity> latestInterview = interviewRepository.findTopByOrderByInterviewCodeDesc();

            String interviewCode = latestInterview
                    .map(interview -> {
                        String latestCode = interview.getInterviewCode().substring(4);
                        int nextCodeNumber = Integer.parseInt(latestCode) + 1;
                        return "INT-" + String.format("%03d", nextCodeNumber);
                    })
                    .orElse("INT-001"); // Default code if no latest interview exists

            InterviewEntity interviewEntity = mapperConfig.toInterviewEntity(recruitmentRequest.getInterviewDto());
            interviewEntity.setInterviewCode(interviewCode);

            InterviewEntity savedEntity = interviewRepository.save(interviewEntity);

            return new ApiResponse(true,"Interview created successfully",savedEntity,null);

        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create interview: " + e.getMessage());
        }
    }


    @Override
    @Transactional
    public ApiResponse getInterviewById(Long id) {
        return interviewRepository.findById(id)
                .map(entity -> new ApiResponse(true,"interview found",mapperConfig.toInterviewDto(entity)))
                .orElseThrow(() -> new EntityNotFoundException("interview with ID " + id + " not found"));
    }

    @Override
    @Transactional
    public ApiResponse getAllInterviewWithCounts() {
//        long activeCount = interviewRepository.countByDelFlag(1);
//        long inactiveCount = interviewRepository.countByDelFlag(0);

        long yetToStartCount = interviewRepository.countByStatus(Status.YET_TO_START);
        long onGoingCount = interviewRepository.countByStatus(Status.ONGOING);

        long activeCount = interviewRepository.countByStatus(Status.ACTIVE);
//        long closedCount = interviewRepository.countByStatus(Status.IN_ACTIVE);
        long completeCount = interviewRepository.countByStatus(Status.COMPLETE);

        long totalActive=yetToStartCount+activeCount+onGoingCount;
        long inactiveCount=completeCount;

        System.out.println("ongoing is "+onGoingCount);
        System.out.println("yet to start is "+yetToStartCount);
        System.out.println("active  is "+activeCount);
        System.out.println("complete is "+completeCount);

        long totalCount = interviewRepository.count();

        RecruitmentCountResponse response = new RecruitmentCountResponse(
                totalCount,totalActive,inactiveCount,activeCount,yetToStartCount,onGoingCount,completeCount);

        return new ApiResponse(true,"getting all interviews",response,null);

    }
    @Override
    @Transactional
    public ApiResponse updateInterviewStatus(Long id, RecruitmentRequest recruitmentRequest) {
        Optional<InterviewEntity> optionalInterview = interviewRepository.findById(id);
        if (optionalInterview.isPresent()) {
            InterviewEntity existingInterview = optionalInterview.get();

            InterviewDto interviewDto = recruitmentRequest.getInterviewDto();

            if (interviewDto.getInterviewCode() != null) {
                existingInterview.setInterviewCode(interviewDto.getInterviewCode());
            }
            if (interviewDto.getInterviewType() != null) {
                existingInterview.setInterviewType(interviewDto.getInterviewType());
            }
            if (interviewDto.getStatus() != null) {
                existingInterview.setStatus(interviewDto.getStatus());
                existingInterview.setDelFlag(interviewDto.getStatus().equals(Status.COMPLETE) ? 0 : 1);
            }
            if (interviewDto.getInterviewer() != null) {
                existingInterview.setInterviewer(interviewDto.getInterviewer());
            }

            if (interviewDto.getInterviewTime() != null) {
                existingInterview.setInterviewTime(interviewDto.getInterviewTime());
            }
            if (interviewDto.getInterviewTime() != null) {
                existingInterview.setInterviewTime(interviewDto.getInterviewTime());
            }
            if (interviewDto.getLocation()!= null) {
                existingInterview.setLocation(interviewDto.getLocation());
            }
            if (interviewDto.getDescription()!= null) {
                existingInterview.setDescription(interviewDto.getDescription());
            }
            if (interviewDto.getTagDetails()!= null) {
                existingInterview.setTagDetails(interviewDto.getTagDetails());
            }
            if (interviewDto.getSelectFeedbackTemplate()!= null) {
                existingInterview.setSelectFeedbackTemplate(interviewDto.getSelectFeedbackTemplate());
            }
            if (interviewDto.getEmailType()!= null) {
                existingInterview.setEmailType(interviewDto.getEmailType());
            }
            if (interviewDto.getAttachments()!= null) {
                existingInterview.setAttachments(interviewDto.getAttachments());
            }

            InterviewEntity updatedEntity = interviewRepository.save(existingInterview);

            return new ApiResponse(true,"Interview updated successfully",mapperConfig.toInterviewDto(updatedEntity),null);
        } else {
            throw new EntityNotFoundException("Interview with ID " + id + " not found");
        }
    }

        @Override
        @Transactional
        public ApiResponse softDeleteJob(Long interviewId) {
            InterviewEntity interviewEntity = interviewRepository.findById(interviewId)
                    .orElseThrow(() -> new EntityNotFoundException("Job not found with ID: " + interviewId));

            interviewEntity.setDelFlag(0);// Assuming delFlag is set to 0 for soft delete
            interviewEntity.setStatus(Status.COMPLETE);
            interviewRepository.save(interviewEntity);
            InterviewDto interviewDto = mapperConfig.toInterviewDto(interviewEntity);

            return new ApiResponse(true,"delete successfully",interviewDto,null);
        }


        // Get All Jobs with Pagination
        @Override
        @Transactional
        public ApiResponse getAllJobs(int page, int pageSize) {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<InterviewEntity> interviewPage = interviewRepository.findAll(pageable);
            List<InterviewDto> interviews = interviewPage.getContent().stream()
                    .map(mapperConfig::toInterviewDto)
                    .collect(Collectors.toList());

            PaginationResponse<InterviewDto> paginationResponse = new PaginationResponse<>(
                    interviewPage.getTotalPages(),
                    interviewPage.getNumber(),
                    interviewPage.getTotalElements(),
                    interviewPage.getSize(),
                    interviews
            );
            return new ApiResponse(true,"jobs retrieved successfully",null,paginationResponse);
        }

        // Global Search for Jobs by jobCode
        @Override
        @Transactional
        public ApiResponse globalSearch(String searchKey, int page, int pageSize) {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<InterviewEntity> interviewEntities = interviewRepository.globalSearch(searchKey, pageable);

            List<InterviewDto> interviewsDtos = interviewEntities.getContent().stream()
                    .map(mapperConfig::toInterviewDto)
                    .collect(Collectors.toList());

            PaginationResponse<InterviewDto> paginationResponse = new PaginationResponse<>(
                    interviewEntities.getTotalPages(),
                    interviewEntities.getNumber(),
                    interviewEntities.getTotalElements(),
                    interviewEntities.getSize(),
                    interviewsDtos
            );

            if (interviewsDtos.isEmpty()) {
                return new ApiResponse(false," no interviews found matching criteria",null,paginationResponse);
            }

            return new ApiResponse(true,"interviews found",null,paginationResponse);
        }
    }


