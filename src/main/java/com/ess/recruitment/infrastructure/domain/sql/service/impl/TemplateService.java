package com.ess.recruitment.infrastructure.domain.sql.service.impl;

//import com.ess.recruitment.core.Req.TemplateReq;
import com.ess.recruitment.core.req.TemplateReq;

import com.ess.recruitment.core.req.TemplateReq;
import com.ess.recruitment.core.resp.ApiResponse;

public interface TemplateService {
    public ApiResponse createTemplate(TemplateReq templateReq);

    public ApiResponse getTemplateById(Long id);

    public ApiResponse getAllTemplates(TemplateReq templateReq);

    public  ApiResponse updateTemplate(Long id,TemplateReq templateReq) ;
    public  ApiResponse count();
    public  ApiResponse search(TemplateReq templateReq);




    }
