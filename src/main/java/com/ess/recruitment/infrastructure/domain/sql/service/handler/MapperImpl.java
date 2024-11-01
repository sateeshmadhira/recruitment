package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.JobsDto;
import com.ess.recruitment.core.dto.TemplateDto;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;

public class MapperImpl implements MapperConfig {
    @Override
    public TemplateDto toDto(TemplateEntity templateEntity) {

      return null;
    }

    @Override
    public TemplateEntity toEntity(TemplateDto templateDto) {
        return null;
    }

    @Override
    public JobsDto toDto(JobsEntity jobsEntity) {
        return null;
    }

    @Override
    public JobsEntity toEntity(JobsDto jobsDto) {
        return null;
    }
}
