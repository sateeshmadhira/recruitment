package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.jobs.JobsDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.infrastructure.domain.sql.model.InterviewEntity;
import org.springframework.stereotype.Component;

@Component
public interface MapperConfig {


     JobsDTO toDtoJob(JobsEntity jobsEntity);
     JobsEntity toEntityJob(JobsDTO jobsDTO);

     InterviewDto toInterviewDto(InterviewEntity interviewEntity);
     InterviewEntity toInterviewEntity(InterviewDto interviewDto);

     ResourcePoolDto toDtoResource(ResourcePoolEntity resourcePoolEntity);
     ResourcePoolEntity toEntityResource(ResourcePoolDto resourcePoolDto);

}
