package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;

public interface InterviewService {
    ApiResponse createInterivew(RecruitmentRequest recruitmentRequest);
     ApiResponse getInterviewById(Long id);
    ApiResponse getAllInterviewWithCounts();
    ApiResponse updateInterviewStatus(Long id, RecruitmentRequest recruitmentRequest);
    ApiResponse softDeleteJob(Long interviewId);
    ApiResponse getAllJobs(int page, int pageSize);
    ApiResponse globalSearch(String searchKey, int page, int pageSize);

}
