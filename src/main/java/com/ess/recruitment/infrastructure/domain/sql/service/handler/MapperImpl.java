package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.core.dto.jobs.JobsDTO;
import com.ess.recruitment.core.dto.template.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.template.TemplateEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements MapperConfig {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TemplateDTO toDtoTemplate(TemplateEntity templateEntity) {
        TemplateDTO templateDTO=modelMapper.map(templateEntity,TemplateDTO.class);
        return templateDTO;
    }
    @Override
    public TemplateEntity toEntityTemplate(TemplateDTO templateDTO) {
        TemplateEntity templateEntity = modelMapper.map(templateDTO, TemplateEntity.class);
        return templateEntity;
    }
    public CandidateSubmissionDto toCandidateDTO(CandidateSubmissionEntity entity) {
        CandidateSubmissionDto candidateSubmissionDto =modelMapper.map(entity,CandidateSubmissionDto.class);
        return candidateSubmissionDto;
    }

    @Override
    public JobsDTO toDtoJob(JobsEntity jobsEntity) {
        JobsDTO jobsDTO=modelMapper.map(jobsEntity,JobsDTO.class);
        return jobsDTO;
    }

    @Override
    public JobsEntity toEntityJob(JobsDTO jobsDTO) {
        JobsEntity jobsEntity = modelMapper.map(jobsDTO, JobsEntity.class);
        return jobsEntity;
    }
    public CandidateSubmissionEntity toCandidateEntity(CandidateSubmissionDto dto) {
        CandidateSubmissionEntity candidateSubmissionEntity = modelMapper.map(dto,CandidateSubmissionEntity.class);
        return candidateSubmissionEntity;
    }
}

