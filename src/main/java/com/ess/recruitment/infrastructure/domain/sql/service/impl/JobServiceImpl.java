package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.PaginationResponse;
import com.ess.recruitment.core.resp.RecruitmentCountResponse;
import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.JobRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private MapperConfig mapperConfig;

    @Override
    @Transactional
    public ApiResponse createJob(RecruitmentRequest recruitmentRequest) {
        Optional<JobsEntity> latestJob = jobRepository.findTopByOrderByJobCodeDesc();
        String jobCode = latestJob
                .map(job -> {
                    String latestCode = job.getJobCode().substring(4);
                    int nextCodeNumber = Integer.parseInt(latestCode) + 1;
                    return "JOB-" + String.format("%03d", nextCodeNumber);
                })
                .orElse("JOB-001");

        JobsEntity jobsEntity = mapperConfig.toEntityJob(recruitmentRequest.getJobsDTO());
        jobsEntity.setJobCode(jobCode);
        JobsEntity savedEntity = jobRepository.save(jobsEntity);
        return new ApiResponse(true, "Job created successfully",
                mapperConfig.toDtoJob(savedEntity));
    }

    @Override
    @Transactional
    public ApiResponse getJobById(Long id) {
        return jobRepository.findById(id)
                .map(entity -> new ApiResponse(true, "Job found", mapperConfig.toDtoJob(entity)))
                .orElseThrow(() -> new EntityNotFoundException("Job with ID " + id + " not found"));
    }

    @Override
    @Transactional
    public ApiResponse getAllJobsWithCounts() {
        long activeCount = jobRepository.countByDelFlag(1);
        long inactiveCount = jobRepository.countByDelFlag(0);
        long totalCount = jobRepository.count();

        RecruitmentCountResponse response = new RecruitmentCountResponse(totalCount, activeCount, inactiveCount, 0, 0, 0, 0);
        PaginationResponse<Object> paginationResponse = new PaginationResponse<>();
        paginationResponse.setContent(List.of(response));
        return new ApiResponse(true, "Job counts fetched successfully", paginationResponse);
    }

    @Override
    @Transactional
    public ApiResponse updateJobStatus(Long id, RecruitmentRequest recruitmentRequest) {
        JobsEntity existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job with ID " + id + " not found"));

        mapperConfig.updateJobEntity(existingJob, recruitmentRequest.getJobsDTO());
        JobsEntity updatedEntity = jobRepository.save(existingJob);
        return new ApiResponse(true, "Job updated successfully", mapperConfig.toDtoJob(updatedEntity));
    }

    @Override
    @Transactional
    public ApiResponse softDeleteJob(Long jobId) {
        JobsEntity job = jobRepository.findById(jobId)
                .orElseThrow(() -> new EntityNotFoundException("Job with ID " + jobId + " not found"));

        job.setDelFlag(0);
        jobRepository.save(job);
        return new ApiResponse(true, "Job deleted successfully", null);
    }

    @Override
    @Transactional
    public ApiResponse getAllJobs(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<JobsEntity> jobPage = jobRepository.findAll(pageable);

        List<JobsDTO> jobs = jobPage.getContent().stream()
                .map(mapperConfig::toDtoJob)
                .collect(Collectors.toList());

        PaginationResponse<JobsDTO> paginationResponse = new PaginationResponse<>(
                jobPage.getTotalPages(),
                jobPage.getNumber(),
                jobPage.getTotalElements(),
                jobPage.getSize(),
                jobs
        );

        return new ApiResponse(true, "Jobs retrieved successfully", paginationResponse);
    }

    @Override
    @Transactional
    public ApiResponse globalSearch(String searchKey, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<JobsEntity> jobEntities = jobRepository.globalSearch(searchKey, pageable);

        List<JobsDTO> jobDTOs = jobEntities.getContent().stream()
                .map(mapperConfig::toDtoJob)
                .collect(Collectors.toList());

        PaginationResponse<JobsDTO> paginationResponse = new PaginationResponse<>(
                jobEntities.getTotalPages(),
                jobEntities.getNumber(),
                jobEntities.getTotalElements(),
                jobEntities.getSize(),
                jobDTOs
        );

        return new ApiResponse(true, "Global search results fetched successfully", paginationResponse);
    }
}
