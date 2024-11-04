package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.jobs.JobsDTO;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;

public interface JobService {
    ApiResponse createJob(RecruitmentRequest recruitmentRequest);
}
