package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidate")
@CrossOrigin("*")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping
    public ResponseEntity<CandidateSubmissionDto> createCandidate(@RequestBody CandidateSubmissionDto candidateDto){
        CandidateSubmissionDto candidateDto1 = candidateService.createCandidate(candidateDto);
        return ResponseEntity.ok(candidateDto1);
    }

    @GetMapping
    public List<CandidateSubmissionDto> getAllCandidate(){
        return candidateService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CandidateSubmissionDto getById(@PathVariable ("id") Long id){
        CandidateSubmissionDto candidateSubmissionDto = candidateService.getById(id);
        return candidateSubmissionDto;
    }
}
