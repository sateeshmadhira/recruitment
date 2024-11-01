package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.Req.TemplateReq;
import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.core.resp.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TemplateService {
    public ApiResponse createTemplate(TemplateReq templateReq);

    public ApiResponse getTemplatetById(Long id);

    public ApiResponse getAllTemplates(TemplateReq templateReq);

    public  ApiResponse updateTemplate(Long id,TemplateReq templateReq) ;

    }
