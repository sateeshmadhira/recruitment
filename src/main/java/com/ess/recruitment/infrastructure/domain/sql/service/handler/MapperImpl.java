package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MapperImpl implements MapperConfig{

    @Autowired
    ModelMapper modelMapper;


    @Override
    public CandidateSubmissionDto toCandidateDTO(CandidateSubmissionEntity entity) {
        CandidateSubmissionDto candidateSubmissionDto =modelMapper.map(entity,CandidateSubmissionDto.class);
        return candidateSubmissionDto;
    }

    @Override
    public CandidateSubmissionEntity toCandidateEntity(CandidateSubmissionDto dto) {
        CandidateSubmissionEntity candidateSubmissionEntity = modelMapper.map(dto,CandidateSubmissionEntity.class);
        return candidateSubmissionEntity;
    }
    }

