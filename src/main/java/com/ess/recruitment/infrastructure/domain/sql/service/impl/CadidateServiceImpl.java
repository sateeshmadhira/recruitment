package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.CandidateSubmissionRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CadidateServiceImpl implements CandidateService{

    @Autowired
    CandidateSubmissionRepository candidateRepository;

    @Autowired
    MapperConfig mapperConfig;

    @Override
    public CandidateSubmissionDto createCandidate(CandidateSubmissionDto candidateDto) {
        CandidateSubmissionEntity candidateEntity = mapperConfig.toCandidateEntity(candidateDto);
        CandidateSubmissionEntity saveCandidate = candidateRepository.save(candidateEntity);
        CandidateSubmissionDto saveDto = mapperConfig.toCandidateDTO(saveCandidate);
        return saveDto;
    }

    @Override
    public List<CandidateSubmissionDto> getAll() {
        List<CandidateSubmissionEntity> candidateSubmissionEntities  = candidateRepository.findAll();
        List<CandidateSubmissionDto> candidateSubmissionDtoList = new ArrayList<>();
        for(CandidateSubmissionEntity candidateSubmissionEntity: candidateSubmissionEntities){

          CandidateSubmissionDto candidateSubmissionDto = mapperConfig.toCandidateDTO(candidateSubmissionEntity);
            candidateSubmissionDtoList.add(candidateSubmissionDto);
        }

        return candidateSubmissionDtoList;
    }

    @Override
    public CandidateSubmissionDto getById(Long id) {
        CandidateSubmissionEntity candidateSubmissionEntities = candidateRepository.getById(id);
        CandidateSubmissionDto candidateSubmissionDto = mapperConfig.toCandidateDTO(candidateSubmissionEntities);
        return candidateSubmissionDto;
    }

    @Override
    public CandidateSubmissionDto updateCandidate(Long id, CandidateSubmissionDto candidateSubmissionDto) {
        CandidateSubmissionEntity candidateSubmissionEntity = candidateRepository.getById(id);


        return null;
    }



}
