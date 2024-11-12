package com.ess.recruitment.infrastructure.domain.sql.service.impl;
import com.ess.recruitment.core.req.TemplateReq;
import com.ess.recruitment.core.resp.ApiResponse;

public interface TemplateService {
    public ApiResponse createTemplate(TemplateReq templateReq);

    public ApiResponse getTemplatetById(Long id);

    public ApiResponse getAllTemplates(TemplateReq templateReq);

    public  ApiResponse updateTemplate(Long id,TemplateReq templateReq) ;

    }
