package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.JobsDTO;

import java.util.List;

public interface JobsService {
    JobsDTO createJob(JobsDTO jobsDTO);

    List<JobsDTO> getAll();

    JobsDTO getById(Long jobId);
}
