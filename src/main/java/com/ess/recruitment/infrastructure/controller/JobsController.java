package com.ess.recruitment.infrastructure.controller;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.req.SearchReq;
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
    public ResponseEntity<ApiResponse> createJob(@RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = jobService.createJob(recruitmentRequest);
        return ResponseEntity.ok(response);
    }

    // Get Job by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getJobById(@PathVariable("id") Long id) {
        ApiResponse response = jobService.getJobById(id);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    // Get All Jobs with Counts
    @GetMapping("/counts")
    public ResponseEntity<ApiResponse> getAllJobsWithCounts() {
        ApiResponse response = jobService.getAllJobsWithCounts();
        return ResponseEntity.ok(response);
    }

    // Update Job
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateJob(@PathVariable("id") Long id, @RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = jobService.updateJobStatus(id, recruitmentRequest);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    // Soft Delete Job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> softDeleteJob(@PathVariable("id") Long jobId) {
        ApiResponse response = jobService.softDeleteJob(jobId);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

//    // Get All Jobs with Pagination
    @GetMapping
    public ResponseEntity<ApiResponse> getAllJobs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        ApiResponse response = jobService.getAllJobs(page, pageSize);
        return ResponseEntity.ok(response);
    }

    // Global Search by jobCode with Pagination
    @PostMapping("/search")
    public ResponseEntity<ApiResponse> globalSearch(@RequestBody SearchReq searchReq) {
        ApiResponse response = jobService.globalSearch(
                searchReq.getSearchKey(),
                searchReq.getPage(),
                searchReq.getPageSize()
        );
        return ResponseEntity.ok(response);
    }
}
