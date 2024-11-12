package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.core.dto.jobs.JobsDTO;
import com.ess.recruitment.core.dto.template.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;

import com.ess.recruitment.core.dto.*;
import com.ess.recruitment.infrastructure.domain.sql.model.*;
import com.ess.recruitment.infrastructure.domain.sql.model.template.TemplateEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl implements MapperConfig {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public JobsDTO toDtoJob(JobsEntity jobsEntity) {
        JobsDTO jobsDTO=modelMapper.map(jobsEntity,JobsDTO.class);
        return jobsDTO;
    }

    @Override
    public JobsEntity toEntityJob(JobsDTO jobsDTO) {
        JobsEntity jobsEntity=modelMapper.map(jobsDTO,JobsEntity.class);
        return jobsEntity;
    }


    @Override
    public InterviewDto toInterviewDto(InterviewEntity interviewEntity) {
        InterviewDto interviewDto =modelMapper.map(interviewEntity, InterviewDto.class);
        return interviewDto;
    }
    @Override
    public InterviewEntity toInterviewEntity(InterviewDto interviewDto) {
        InterviewEntity interviewEntity =modelMapper.map(interviewDto, InterviewEntity.class);
        return interviewEntity;
    }

    @Override
    public ResourcePoolDto toDtoResource(ResourcePoolEntity resourcePoolEntity) {
        ResourcePoolDto resourcePoolDto=modelMapper.map(resourcePoolEntity,ResourcePoolDto.class);
        return resourcePoolDto;
    }

    @Override
    public ResourcePoolEntity toEntityResource(ResourcePoolDto resourcePoolDto) {
        ResourcePoolEntity resourcePoolEntity=modelMapper.map(resourcePoolDto, ResourcePoolEntity.class);
        return resourcePoolEntity;
    }

    @Override
    public TemplateDTO toDtoTemplate(TemplateEntity templateEntity) {
        TemplateDTO templateDTO=modelMapper.map(templateEntity,TemplateDTO.class);
        return templateDTO;
    }
    @Override
    public TemplateEntity toEntityTemplate(TemplateDTO templateDTO) {
        TemplateEntity templateEntity=modelMapper.map(templateDTO,TemplateEntity.class);
        return templateEntity;
    }
}
