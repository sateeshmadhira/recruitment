package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.JobsDto;
import com.ess.recruitment.core.dto.TemplateDto;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import org.springframework.stereotype.Component;

@Component
public interface MapperConfig {
    TemplateDto toDto(TemplateEntity templateEntity);
    TemplateEntity toEntity(TemplateDto templateDto);
    JobsDto toDto(JobsEntity jobsEntity);
    JobsEntity toEntity(JobsDto jobsDto);
}
