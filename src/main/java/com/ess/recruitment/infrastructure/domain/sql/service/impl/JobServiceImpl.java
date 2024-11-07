package com.ess.recruitment.infrastructure.domain.sql.service.impl;


import com.ess.recruitment.core.Req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.JobRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private MapperConfig mapperConfig;

    // Create Jobs
    @Override
    public ApiResponse createJob(RecruitmentRequest recruitmentRequest) {


        try {
            Optional<JobsEntity> latestJob = jobRepository.findTopByOrderByJobCodeDesc();
            String jobCode = latestJob
                    .map(a -> {
                        String latestCode = a.getJobCode().substring(4);
                        int nextCodeNumber = Integer.parseInt(latestCode) + 1;
                        return "ASG-" + String.format("%03d", nextCodeNumber);
                    })
                    .orElse("ASG-001");
            JobsEntity jobsEntity = mapperConfig.toEntityJob(recruitmentRequest.getJobsDTO());
            jobsEntity.setJobCode(jobCode);
            JobsEntity savedEntity = jobRepository.save(jobsEntity);
            return new ApiResponse(true, "Assignment created successfully",
                    mapperConfig.toDtoJob(savedEntity), null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create assignment: " + e.getMessage());
        }
    }
}
