package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.*;
import com.ess.recruitment.core.dto.jobs.JobDescriptionDTO;
import com.ess.recruitment.core.dto.jobs.JobsDTO;
import com.ess.recruitment.core.dto.jobs.RecruitmentTeamDTO;
import com.ess.recruitment.core.dto.template.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.*;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobDescriptionEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.RecruitmentTeamEntity;
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
        TemplateEntity templateEntity=modelMapper.map(templateDTO,TemplateEntity.class);
        return templateEntity;
    }

    @Override
    public JobsDTO toDtoJob(JobsEntity jobsEntity) {
        JobsDTO jobsDTO=modelMapper.map(jobsEntity,JobsDTO.class);
        if(jobsEntity.getJobDescriptionEntity()!=null){
            JobDescriptionDTO jobDescriptionDTO=modelMapper.map(jobsEntity.getJobDescriptionEntity(),JobDescriptionDTO.class);
            jobDescriptionDTO.setJobId(jobsDTO.getJobId());
            jobsDTO.setJobDescriptionDTO(jobDescriptionDTO);
        }
        if(jobsEntity.getPayAndBillingDetailsEntity()!=null){
            PayAndBillingDetailsDTO payAndBillingDetailsDTO=
                    modelMapper.map(jobsEntity.getPayAndBillingDetailsEntity(),PayAndBillingDetailsDTO.class);
            payAndBillingDetailsDTO.setJobId(jobsDTO.getJobId());
            jobsDTO.setPayAndBillingDetailsDTO(payAndBillingDetailsDTO);
        }
        if(jobsEntity.getRecruitmentTeamEntity()!=null){
            RecruitmentTeamDTO recruitmentTeamDTO=modelMapper.map(jobsEntity.getRecruitmentTeamEntity(), RecruitmentTeamDTO.class);
            recruitmentTeamDTO.setJobId(jobsDTO.getJobId());
            jobsDTO.setRecruitmentTeamDTO(recruitmentTeamDTO);
        }
        return jobsDTO;
    }

    @Override
    public JobsEntity toEntityJob(JobsDTO jobsDTO) {
        JobsEntity jobsEntity=modelMapper.map(jobsDTO,JobsEntity.class);
        if(jobsDTO.getJobDescriptionDTO()!=null){
            JobDescriptionEntity jobDescriptionEntity=modelMapper.map(jobsDTO.getJobDescriptionDTO(),JobDescriptionEntity.class);
            jobDescriptionEntity.setJobsEntity(jobsEntity);
            jobsEntity.setJobDescriptionEntity(jobDescriptionEntity);
        }
        if(jobsDTO.getPayAndBillingDetailsDTO()!=null){
            PayAndBillingDetailsEntity payAndBillingDetailsEntity=
                    modelMapper.map(jobsDTO.getPayAndBillingDetailsDTO(),PayAndBillingDetailsEntity.class);
            payAndBillingDetailsEntity.setJobsEntity(jobsEntity);
            jobsEntity.setPayAndBillingDetailsEntity(payAndBillingDetailsEntity);
        }
        if(jobsDTO.getRecruitmentTeamDTO()!=null){
            RecruitmentTeamEntity recruitmentTeamEntity=modelMapper.map(jobsDTO.getRecruitmentTeamDTO(),RecruitmentTeamEntity.class);
            recruitmentTeamEntity.setJobsEntity(jobsEntity);;
            jobsEntity.setRecruitmentTeamEntity(recruitmentTeamEntity);
        }
        return jobsEntity;
    }
}
