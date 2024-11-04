package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.template.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.template.TemplateEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.TemplateRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    MapperConfig mapperConfig;


    @Override
    public TemplateDTO createTemplate(TemplateDTO templateDTO) {
        TemplateEntity templateEntity=mapperConfig.toEntityTemplate(templateDTO);
        TemplateEntity saveTemplateEntity=templateRepository.save(templateEntity);
        TemplateDTO saveDto=mapperConfig.toDtoTemplate(saveTemplateEntity);
        return saveDto;
    }
}
