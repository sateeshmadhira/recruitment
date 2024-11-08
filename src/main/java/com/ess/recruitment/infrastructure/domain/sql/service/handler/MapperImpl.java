package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.*;
import com.ess.recruitment.infrastructure.domain.sql.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MapperImpl implements MapperConfig {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TemplateDTO toDto(TemplateEntity templateEntity) {
        TemplateDTO templateDTO = modelMapper.map(templateEntity, TemplateDTO.class);
        if (templateEntity.getPayAndBillingDetailsEntity() != null) {
            PayAndBillingDetailsDTO payAndBillingDetailsDTO =
                    modelMapper.map(templateEntity.getPayAndBillingDetailsEntity(), PayAndBillingDetailsDTO.class);
            payAndBillingDetailsDTO.setTemplateId(templateDTO.getTemplateId());
            templateDTO.setPayAndBillingDetailsDto(payAndBillingDetailsDTO);
        }
        return templateDTO;
    }

    @Override
    public TemplateEntity toEntity(TemplateDTO templateDTO) {
        TemplateEntity templateEntity = modelMapper.map(templateDTO, TemplateEntity.class);
        if (templateDTO.getPayAndBillingDetailsDto() != null) {
            PayAndBillingDetailsEntity payAndBillingDetailsEntity =
                    modelMapper.map(templateDTO.getPayAndBillingDetailsDto(), PayAndBillingDetailsEntity.class);
            payAndBillingDetailsEntity.setTemplateEntity(templateEntity);
            templateEntity.setPayAndBillingDetailsEntity(payAndBillingDetailsEntity);
        }
        return templateEntity;
    }

    @Override
    public JobsDTO toDto(JobsEntity jobsEntity) {
        JobsDTO jobsDTO = modelMapper.map(jobsEntity, JobsDTO.class);
        if (jobsEntity.getJobDescriptionEntity() != null) {
            JobDescriptionDTO jobDescriptionDTO = modelMapper.map(jobsEntity.getJobDescriptionEntity(), JobDescriptionDTO.class);
            jobDescriptionDTO.setJobId(jobDescriptionDTO.getJobId());
            jobsDTO.setJobDescriptionDTO(jobDescriptionDTO);
        }
        return jobsDTO;
    }

    @Override
    public JobsEntity toEntity(JobsDTO jobsDTO) {
        JobsEntity jobsEntity = modelMapper.map(jobsDTO, JobsEntity.class);
        if (jobsDTO.getJobDescriptionDTO() != null) {
            JobDescriptionEntity jobDescriptionEntity = modelMapper.map(jobsDTO.getJobDescriptionDTO(), JobDescriptionEntity.class);
            jobDescriptionEntity.setJobsEntity(jobsEntity);
            jobsEntity.setJobDescriptionEntity(jobDescriptionEntity);
        }
        return jobsEntity;
    }

    @Override
    public ResourcePoolDto toDto(ResourcePoolEntity resourcePoolEntity) {
        ResourcePoolDto resourcePoolDto=modelMapper.map(resourcePoolEntity,ResourcePoolDto.class);
        return resourcePoolDto;
    }

    @Override
    public ResourcePoolEntity toEntity(ResourcePoolDto resourcePoolDto) {
        ResourcePoolEntity resourcePoolEntity=modelMapper.map(resourcePoolDto, ResourcePoolEntity.class);
        return resourcePoolEntity;
    }
}
