package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.infrastructure.domain.sql.model.InterviewEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import org.springframework.stereotype.Component;

@Component
public interface MapperConfig {


     JobsDTO toDtoJob(JobsEntity jobsEntity);
     JobsEntity toEntityJob(JobsDTO jobsDTO);

     CandidateSubmissionDto toCandidateDTO(CandidateSubmissionEntity entity);
     CandidateSubmissionEntity toCandidateEntity(CandidateSubmissionDto dto);

     InterviewDto toInterviewDto(InterviewEntity interviewEntity);
     InterviewEntity toInterviewEntity(InterviewDto interviewDto);

     ResourcePoolDto toDtoResource(ResourcePoolEntity resourcePoolEntity);
     ResourcePoolEntity toEntityResource(ResourcePoolDto resourcePoolDto);

     TemplateEntity toEntityTemplate(TemplateDTO templateDTO);
     TemplateDTO toDtoTemplate(TemplateEntity templateEntity);

     void updateJobEntity(JobsEntity jobsEntity, JobsDTO jobsDTO);

}
