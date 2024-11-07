package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.jobs.JobsDTO;

import com.ess.recruitment.core.dto.template.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.template.TemplateEntity;
import org.springframework.stereotype.Component;

@Component
public interface MapperConfig {
     TemplateDTO toDtoTemplate(TemplateEntity templateEntity);
//     TemplateEntity toEntityTemplate(TemplateDTO templateDTO);

     JobsDTO toDtoJob(JobsEntity jobsEntity);

     JobsEntity toEntityJob(JobsDTO jobsDTO);

     TemplateEntity toEntityTemplate(TemplateDTO templateDTO);
}
