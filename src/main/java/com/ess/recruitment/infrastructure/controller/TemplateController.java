package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.constants.RecruitmentConstants;
import com.ess.recruitment.core.req.TemplateReq;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.TemplateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RecruitmentConstants.RECRUITMENT_PATH_URL+"/template")
@CrossOrigin("*")
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @PostMapping
    public ResponseEntity<ApiResponse> createTemplate(@Valid @RequestBody TemplateReq templateReq){
       ApiResponse apiResponse= templateService.createTemplate(templateReq);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(RecruitmentConstants.RECRUITMENT_BY_ID)
    public ResponseEntity<ApiResponse> getTemplate(@PathVariable("id") Long id ){
        ApiResponse  apiResponse = templateService.getTemplateById(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("getAllTemplate")
    public ResponseEntity<ApiResponse> getAllTemplate(@RequestBody TemplateReq templateReq){
        ApiResponse apiResponse= templateService.getAllTemplates( templateReq);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("countTemp")
    public ResponseEntity<ApiResponse> countActiveInActiveTemp( ){
        ApiResponse  apiResponse = templateService.count();
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping(RecruitmentConstants.RECRUITMENT_GET_COUNTS)
    public ResponseEntity<ApiResponse> searchTemplate(@RequestBody TemplateReq templateReq){
        ApiResponse apiResponse= templateService.search(templateReq);
        return ResponseEntity.ok(apiResponse);
    }



    @PutMapping(RecruitmentConstants.RECRUITMENT_BY_ID)
    public ResponseEntity<ApiResponse> updateTemplate(@PathVariable("id") Long id,@RequestBody  TemplateReq templateReq ){
        ApiResponse  apiResponse= templateService.updateTemplate(id,templateReq);
        return ResponseEntity.ok(apiResponse);
    }
}
