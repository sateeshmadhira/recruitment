package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.Req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobsController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<ApiResponse> createJob(@RequestBody RecruitmentRequest recruitmentRequest){
        ApiResponse response = jobService.createJob(recruitmentRequest);
        return ResponseEntity.ok(response);
    }
}
