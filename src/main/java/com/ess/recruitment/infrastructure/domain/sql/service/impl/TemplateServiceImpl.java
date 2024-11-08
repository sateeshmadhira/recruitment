package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import com.ess.recruitment.infrastructure.domain.sql.repo.TemplateRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    MapperConfig mapperConfig;


    @Override
    public TemplateDTO createTemplate(TemplateDTO templateDTO) {
        TemplateEntity templateEntity = mapperConfig.toEntity(templateDTO);
        TemplateEntity saveTemplateEntity = templateRepository.save(templateEntity);
        TemplateDTO saveDto = mapperConfig.toDto(saveTemplateEntity);
        return saveDto;
    }

    @Override
    public TemplateDTO getById(Long templateId) {
        Optional<TemplateEntity> templateEntityOptional=templateRepository.findById(templateId);
        return templateEntityOptional
                .map(templateEntity -> new TemplateDTO())
                .orElseThrow(()-> new EntityNotFoundException("Template with id"+templateId+"not found"));
    }
}
