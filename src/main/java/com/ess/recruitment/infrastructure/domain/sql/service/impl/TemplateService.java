package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.TemplateDTO;

public interface TemplateService {
    TemplateDTO createTemplate(TemplateDTO templateDTO);
    //TemplateDTO getAll(TemplateDTO templateDTO);
    TemplateDTO getById(Long templateId);
}
