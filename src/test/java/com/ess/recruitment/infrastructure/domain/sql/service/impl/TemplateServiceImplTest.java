package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ess.recruitment.core.req.TemplateReq;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.TemplateRepository;

import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TemplateServiceImplTest {

    @InjectMocks
    TemplateServiceImpl templateService;

    @Mock
    TemplateRepository templateRepository;



    @Mock
    MapperConfig mapperConfig;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTemplateSuccess(){
        TemplateReq request=new TemplateReq();
        TemplateEntity templateEntity=new TemplateEntity();
        templateEntity.setTemplateCode("TEMP-001");
        when(mapperConfig.toEntityTemplate(request.getTemplateDTO())).thenReturn(templateEntity);
        when(templateRepository.save(any(TemplateEntity.class))).thenReturn(templateEntity);
        ApiResponse response=templateService.createTemplate(request);
        assertTrue(response.isSuccess());
        assertEquals("Template Saved Successfully",response.getMessage());


    }
    @Test
    void createTemplateFail(){
        TemplateReq request=new TemplateReq();
        when(mapperConfig.toEntityTemplate(request.getTemplateDTO())).thenThrow(new RuntimeException("Mapping Error"));
        assertThrows(IllegalAccessException.class,()->templateService.createTemplate(request));
    }
}