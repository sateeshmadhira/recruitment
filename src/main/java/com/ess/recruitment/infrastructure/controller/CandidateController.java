package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.req.SearchReq;
import com.ess.recruitment.core.resp.ApiResponse;
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
    public ResponseEntity<ApiResponse> createCandidate(@RequestBody RecruitmentRequest recruitmentRequest){
        ApiResponse apiResponse = candidateService.createCandidate(recruitmentRequest);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getJobById(@PathVariable("id") Long id) {
        ApiResponse response = candidateService.getCandidateById(id);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @GetMapping("/counts")
    public ResponseEntity<ApiResponse> getAllJobsWithCounts() {
        ApiResponse response = candidateService.getAllCandidatesWithCounts();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateJob(@PathVariable("id") Long id, @RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = candidateService.updateCandidateStatus(id, recruitmentRequest);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> softDeleteJob(@PathVariable("id") Long jobId) {
        ApiResponse response = candidateService.softDeleteCandidate(jobId);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponse> globalSearch(@RequestBody SearchReq searchReq) {
        ApiResponse response = candidateService.globalSearch(
                searchReq.getSearchKey(),
                searchReq.getPage(),
                searchReq.getPageSize()
        );
        return ResponseEntity.ok(response);
    }

}
