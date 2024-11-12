package com.ess.recruitment.infrastructure.controller;


import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.req.SearchReq;
import com.ess.recruitment.core.resp.ApiResponse;
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
    public ResponseEntity<ApiResponse> createInterview(@RequestBody RecruitmentRequest request){
        ApiResponse response=interviewService.createInterivew(request);
        return ResponseEntity.ok(response);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getJobById(@PathVariable("id") Long id) {
        ApiResponse response = interviewService.getInterviewById(id);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    // Get All Jobs with Counts
    @GetMapping("/counts")
    public ResponseEntity<ApiResponse> getAllJobsWithCounts() {
        ApiResponse response = interviewService.getAllInterviewWithCounts();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateJob(@PathVariable("id") Long id, @RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = interviewService.updateInterviewStatus(id, recruitmentRequest);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    // Soft Delete Job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> softDeleteInterview(@PathVariable("id") Long interviewId) {
        ApiResponse response = interviewService.softDeleteJob(interviewId);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    // Get All Jobs with Pagination
    @GetMapping
    public ResponseEntity<ApiResponse> getAllJobs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        ApiResponse response = interviewService.getAllJobs(page, pageSize);
        return ResponseEntity.ok(response);
    }

    // Global Search by jobCode with Pagination
    @PostMapping("/search")
    public ResponseEntity<ApiResponse> globalSearch(@RequestBody SearchReq searchReq) {
        ApiResponse response = interviewService.globalSearch(
                searchReq.getSearchKey(),
                searchReq.getPage(),
                searchReq.getPageSize()
        );
        return ResponseEntity.ok(response);
    }
}
