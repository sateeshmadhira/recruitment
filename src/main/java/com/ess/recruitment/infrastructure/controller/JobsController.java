package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Jobs")
@CrossOrigin("*")
public class JobsController {
    @Autowired
    JobsService jobsService;

    @PostMapping
    public ResponseEntity<JobsDTO>createJob(@RequestBody JobsDTO jobsDTO){
        JobsDTO dto=jobsService.createJob(jobsDTO);
        return ResponseEntity.ok(dto);

    }
//    @PostMapping
//    public ResponseEntity<JobsDTO>getAll(@RequestBody JobsDTO jobsDTO){
//        JobsDTO dto=jobsService.getAll(jobsDTO);
//        return ResponseEntity.ok(dto);
//    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<JobsDTO>getById(@PathVariable("id") Long jobId){
        JobsDTO dto=jobsService.getById(jobId);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/all")
    public List<JobsDTO> getAllJobs(){
        return jobsService.getAll();
    }
}
