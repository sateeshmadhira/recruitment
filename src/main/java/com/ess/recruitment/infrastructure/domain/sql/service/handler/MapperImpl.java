package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.JobDescriptionDTO;
import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.core.dto.PayAndBillingDetailsDTO;
import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.JobDescriptionEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.PayAndBillingDetailsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class MapperImpl implements MapperConfig {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TemplateDTO toDto(TemplateEntity templateEntity) {
        TemplateDTO templateDTO=modelMapper.map(templateEntity,TemplateDTO.class);
        if(templateEntity.getPayAndBillingDetailsEntity()!=null){
            PayAndBillingDetailsDTO payAndBillingDetailsDTO=
                    modelMapper.map(templateEntity.getPayAndBillingDetailsEntity(),PayAndBillingDetailsDTO.class);
            payAndBillingDetailsDTO.setTemplateId(templateDTO.getTemplateId());
            templateDTO.setPayAndBillingDetailsDTO(payAndBillingDetailsDTO);
        }
        return templateDTO;
    }
    @Override
    public TemplateEntity toEntity(TemplateDTO templateDTO) {
        TemplateEntity templateEntity=modelMapper.map(templateDTO,TemplateEntity.class);
        if(templateDTO.getPayAndBillingDetailsDTO()!=null){
            PayAndBillingDetailsEntity payAndBillingDetailsEntity=
                    modelMapper.map(templateDTO.getPayAndBillingDetailsDTO(), PayAndBillingDetailsEntity.class);
            payAndBillingDetailsEntity.setTemplateEntity(templateEntity);
            templateEntity.setPayAndBillingDetailsEntity(payAndBillingDetailsEntity);
        }
        return templateEntity;
    }

    @Override
    public JobsDTO toDto(JobsEntity jobsEntity) {
        JobsDTO jobsDTO=modelMapper.map(jobsEntity,JobsDTO.class);
        if(jobsEntity.getJobDescriptionEntity()!=null){
            JobDescriptionDTO jobDescriptionDTO=modelMapper.map(jobsEntity.getJobDescriptionEntity(),JobDescriptionDTO.class);
            jobDescriptionDTO.setJobId(jobsDTO.getJobId());
            jobsDTO.setJobDescriptionDTO(jobDescriptionDTO);
        }
        return jobsDTO;
    }

    @Override
    public JobsEntity toEntity(JobsDTO jobsDTO) {
        return null;
    }
}
