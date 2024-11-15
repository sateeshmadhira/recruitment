package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.constants.RecruitmentConstants;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.req.SearchReq;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RecruitmentConstants.RECRUITMENT_PATH_URL + "/jobs")
@CrossOrigin("*")
@Tag(name = "Jobs", description = "Endpoints for managing jobs")
public class JobsController {

    @Autowired
    private JobService jobService;

    @PostMapping
    @Operation(summary = "Create a Job", description = "Creates a new job with the provided details.")
    public ResponseEntity<ApiResponse> createJob(@Valid @RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = jobService.createJob(recruitmentRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping(RecruitmentConstants.RECRUITMENT_BY_ID)
    @Operation(summary = "Get Job by ID", description = "Retrieves job details by its unique ID.")
    public ResponseEntity<ApiResponse> getJobById(@Parameter(description = "Unique ID of the job", required = true)
                                                      @PathVariable("id") Long id) {
        ApiResponse response = jobService.getJobById(id);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @GetMapping(RecruitmentConstants.RECRUITMENT_GET_COUNTS)
    @Operation(summary = "Get Jobs with Counts", description = "Fetches counts of jobs by their statuses.")
    public ResponseEntity<ApiResponse> getAllJobsWithCounts() {
        ApiResponse response = jobService.getAllJobsWithCounts();
        return ResponseEntity.ok(response);
    }

    @PutMapping(RecruitmentConstants.RECRUITMENT_BY_ID)
    @Operation(summary = "Update a Job", description = "Updates an existing job by its ID.")
    public ResponseEntity<ApiResponse> updateJob(@Parameter(description = "Unique ID of the job", required = true)
                                                     @PathVariable("id") Long id, @RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = jobService.updateJobStatus(id, recruitmentRequest);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @DeleteMapping(RecruitmentConstants.RECRUITMENT_BY_ID)
    @Operation(summary = "Soft Delete a Job", description = "Marks a job as deleted by its ID.")
    public ResponseEntity<ApiResponse> softDeleteJob(
            @Parameter(description = "Unique ID of the job", required = true)
            @PathVariable("id") Long jobId) {
        ApiResponse response = jobService.softDeleteJob(jobId);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @GetMapping
    @Operation(summary = "Get All Jobs with Pagination", description = "Retrieves a paginated list of all jobs.")
    public ResponseEntity<ApiResponse> getAllJobs(
            @Parameter(description = "Page number (default is 0)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size (default is 10)") @RequestParam(defaultValue = "10") int pageSize) {
        ApiResponse response = jobService.getAllJobs(page, pageSize);
        return ResponseEntity.ok(response);
    }

    @PostMapping(RecruitmentConstants.RECRUITMENT_GLOBAL_SEARCH)
    @Operation(summary = "Global Search for Jobs", description = "Searches for jobs globally by job code.")
    public ResponseEntity<ApiResponse> globalSearch(@RequestBody SearchReq searchReq) {
        ApiResponse response = jobService.globalSearch(
                searchReq.getSearchKey(),
                searchReq.getPage(),
                searchReq.getPageSize()
        );
        return ResponseEntity.ok(response);
    }
}
