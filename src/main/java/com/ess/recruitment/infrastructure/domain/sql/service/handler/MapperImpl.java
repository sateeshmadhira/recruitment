package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;

import com.ess.recruitment.core.dto.*;
import com.ess.recruitment.infrastructure.domain.sql.model.*;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
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


    public CandidateSubmissionDto toCandidateDTO(CandidateSubmissionEntity entity) {
        CandidateSubmissionDto candidateSubmissionDto =modelMapper.map(entity,CandidateSubmissionDto.class);
        return candidateSubmissionDto;
    }



    public CandidateSubmissionEntity toCandidateEntity(CandidateSubmissionDto dto) {
        CandidateSubmissionEntity candidateSubmissionEntity = modelMapper.map(dto,CandidateSubmissionEntity.class);
        return candidateSubmissionEntity;
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

    /**
     * Updates an existing JobsEntity with properties from JobsDTO.
     */
    @Override
    public void updateJobEntity(JobsEntity jobsEntity, JobsDTO jobsDTO) {
        if (jobsDTO.getJobCode() != null) jobsEntity.setJobCode(jobsDTO.getJobCode());
        if (jobsDTO.getJobTitle() != null) jobsEntity.setJobTitle(jobsDTO.getJobTitle());
        if (jobsDTO.getStatus() != null) jobsEntity.setStatus(jobsDTO.getStatus());
        if (jobsDTO.getTechnology() != null) jobsEntity.setTechnology(jobsDTO.getTechnology());
        if (jobsDTO.getEmploymentType() != null) jobsEntity.setEmploymentType(jobsDTO.getEmploymentType());
        if (jobsDTO.getPrimarySkills() != null) jobsEntity.setPrimarySkills(jobsDTO.getPrimarySkills());
        if (jobsDTO.getSecondarySkills() != null) jobsEntity.setSecondarySkills(jobsDTO.getSecondarySkills());
        if (jobsDTO.getJobDescription() != null) jobsEntity.setJobDescription(jobsDTO.getJobDescription());
        if (jobsDTO.getRelevantExperience() > 0) jobsEntity.setRelevantExperience(jobsDTO.getRelevantExperience());
        if (jobsDTO.getDomain() != null) jobsEntity.setDomain(jobsDTO.getDomain());
        if (jobsDTO.getPayRate() != null) jobsEntity.setPayRate(jobsDTO.getPayRate());
        if (jobsDTO.getTaAssignee() != null) jobsEntity.setTaAssignee(jobsDTO.getTaAssignee());
        if (jobsDTO.getLocation() != null) jobsEntity.setLocation(jobsDTO.getLocation());
        if (jobsDTO.getNoOfSubmission() > 0) jobsEntity.setNoOfSubmission(jobsDTO.getNoOfSubmission());
        if (jobsDTO.getVendor() != null) jobsEntity.setVendor(jobsDTO.getVendor());
        if (jobsDTO.getWorkExperience() > 0) jobsEntity.setWorkExperience(jobsDTO.getWorkExperience());
        if (jobsDTO.getNoOfPositions() > 0) jobsEntity.setNoOfPositions(jobsDTO.getNoOfPositions());
        if (jobsDTO.getTargetDate() != null) jobsEntity.setTargetDate(jobsDTO.getTargetDate());
        if (jobsDTO.getWorkType() != null) jobsEntity.setWorkType(jobsDTO.getWorkType());
        if (jobsDTO.getLanguagesRequired() != null) jobsEntity.setLanguagesRequired(jobsDTO.getLanguagesRequired());
        if (jobsDTO.getPriority() != null) jobsEntity.setPriority(jobsDTO.getPriority());
        if (jobsDTO.getProjectId() != null) jobsEntity.setProjectId(jobsDTO.getProjectId());
        if (jobsDTO.getClientJobId() != null) jobsEntity.setClientJobId(jobsDTO.getClientJobId());
        if (jobsDTO.getAccountManager() != null) jobsEntity.setAccountManager(jobsDTO.getAccountManager());
    }
}

