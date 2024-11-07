package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.Req.RecruitmentRequest;
import com.ess.recruitment.core.dto.jobs.JobsDTO;

import com.ess.recruitment.core.resp.ApiResponse;

public interface JobService {
    ApiResponse createJob(RecruitmentRequest recruitmentRequest);
    ApiResponse getJobById(Long id);
    ApiResponse getAllJobsWithCounts();
    ApiResponse updateJobStatus(Long id, RecruitmentRequest recruitmentRequest);
    ApiResponse softDeleteJob(Long jobId);
    ApiResponse getAllJobs(int page, int pageSize);
    ApiResponse globalSearch(String searchKey, int page, int pageSize);
}
