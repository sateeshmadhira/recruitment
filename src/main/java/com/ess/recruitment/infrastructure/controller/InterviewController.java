package com.ess.recruitment.infrastructure.controller;


import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
@CrossOrigin("*")
public class InterviewController {
    @Autowired
    InterviewService interviewService;

    @PostMapping
    public ResponseEntity<InterviewDto> createInterview(@RequestBody InterviewDto interviewDto){
        InterviewDto dto= interviewService.createInterivew(interviewDto);
        return ResponseEntity.ok(dto);
    }
}
