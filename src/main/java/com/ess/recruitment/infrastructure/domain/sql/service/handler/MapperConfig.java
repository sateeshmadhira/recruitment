package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import org.springframework.stereotype.Component;

@Component
public interface MapperConfig {
     TemplateDTO toDto(TemplateEntity templateEntity);
     TemplateEntity toEntity(TemplateDTO templateDTO);

     JobsDTO toDto(JobsEntity jobsEntity);
     JobsEntity toEntity(JobsDTO jobsDTO);

     ResourcePoolDto toDto(ResourcePoolEntity resourcePoolEntity);
     ResourcePoolEntity toEntity(ResourcePoolDto resourcePoolDto);

}
