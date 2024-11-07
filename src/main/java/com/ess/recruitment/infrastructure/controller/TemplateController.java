package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.Req.TemplateReq;
import com.ess.recruitment.core.dto.template.TemplateDTO;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/template")
@CrossOrigin("*")
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @PostMapping("saveTemplate")
    public ResponseEntity<ApiResponse> createTemplate(@RequestBody TemplateReq templateReq){
       ApiResponse apiResponse= templateService.createTemplate(templateReq);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("getTemplate/{id}")
    public ResponseEntity<ApiResponse> getTemplate(@PathVariable("id") Long id ){
        ApiResponse  apiResponse = templateService.getTemplatetById(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("getAllTemplate")
    public ResponseEntity<ApiResponse> getALLTemplate(@RequestBody TemplateReq templateReq){
        ApiResponse apiResponse= templateService.getAllTemplates( templateReq);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("updateTemplate/{id}")
    public ResponseEntity<ApiResponse> updateTemplate(@PathVariable("id") Long id,@RequestBody  TemplateReq templateReq ){
        ApiResponse  apiResponse= templateService.updateTemplate(id,templateReq);
        return ResponseEntity.ok(apiResponse);
    }
}
