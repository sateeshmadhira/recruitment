package com.ess.recruitment.infrastructure.domain.sql.service.impl;
import com.ess.recruitment.core.dto.jobs.JobsDTO;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.PaginationResponse;
import com.ess.recruitment.core.resp.RecruitmentCountResponse;
import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.JobRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private MapperConfig mapperConfig;

    // Helper method to create Pagination Response
    private <T> PaginationResponse<T> createPaginationResponse(Page<T> page) {
        return new PaginationResponse<>(

                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getSize(),
                page.getContent()
        );
    }

    // Create Job
    @Override
    @Transactional
    public ApiResponse createJob(RecruitmentRequest recruitmentRequest) {
        try {
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
                    mapperConfig.toDtoJob(savedEntity), null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create job: " + e.getMessage());
        }
    }

    // Get Job by ID
    @Override
    @Transactional
    public ApiResponse getJobById(Long id) {
        return jobRepository.findById(id)
                .map(entity -> new ApiResponse(true, "Job found", mapperConfig.toDtoJob(entity), null))
                .orElseThrow(() -> new EntityNotFoundException("Job with ID " + id + " not found"));
    }

    // Get All Jobs With Counts
    @Override
    @Transactional
    public ApiResponse getAllJobsWithCounts() {
        long activeCount = jobRepository.countByDelFlag(1);
        long inactiveCount = jobRepository.countByDelFlag(0);

        long yetToStartCount = jobRepository.countByStatus(Status.YET_TO_START);
        long onGoingCount = jobRepository.countByStatus(Status.ONGOING);
        long openCount = jobRepository.countByStatus(Status.ACTIVE);
//        long closedCount = jobRepository.countByStatus(Status.IN_ACTIVE);
        long completeCount = jobRepository.countByStatus(Status.COMPLETE);

        activeCount=yetToStartCount+openCount+onGoingCount;
        inactiveCount=completeCount;

        long totalCount = jobRepository.count();

        RecruitmentCountResponse response = new RecruitmentCountResponse(
                totalCount,activeCount,inactiveCount,openCount,yetToStartCount,onGoingCount,completeCount);

        return new ApiResponse(true, "Getting all jobs", response, null);

    }

    // Update job status and set isActive accordingly
    @Override
    @Transactional
    public ApiResponse updateJobStatus(Long id, RecruitmentRequest recruitmentRequest) {
        Optional<JobsEntity> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            JobsEntity existingJob = optionalJob.get();
            JobsDTO jobDTO = recruitmentRequest.getJobsDTO();

            if (jobDTO.getJobCode() != null) {
                existingJob.setJobCode(jobDTO.getJobCode());
            }
            if (jobDTO.getJobTitle() != null) {
                existingJob.setJobTitle(jobDTO.getJobTitle());
            }
            if (jobDTO.getStatus() != null) {
                existingJob.setStatus(jobDTO.getStatus());
                existingJob.setDelFlag(jobDTO.getStatus().equals(Status.COMPLETE) ? 0 : 1);
            }
            if (jobDTO.getTechnology() != null) {
                existingJob.setTechnology(jobDTO.getTechnology());
            }
            if (jobDTO.getEmploymentType() != null) {
                existingJob.setEmploymentType(jobDTO.getEmploymentType());
            }
            if (jobDTO.getPrimarySkills() != null) {
                existingJob.setPrimarySkills(jobDTO.getPrimarySkills());
            }
            if (jobDTO.getSecondarySkills() != null) {
                existingJob.setSecondarySkills(jobDTO.getSecondarySkills());
            }
            if (jobDTO.getJobDescription() != null) {
                existingJob.setJobDescription(jobDTO.getJobDescription());
            }
            if (jobDTO.getRelevantExperience() > 0) {
                existingJob.setRelevantExperience(jobDTO.getRelevantExperience());
            }
            if (jobDTO.getDomain() != null) {
                existingJob.setDomain(jobDTO.getDomain());
            }
            if (jobDTO.getPayRate() != null) {
                existingJob.setPayRate(jobDTO.getPayRate());
            }
            if (jobDTO.getTaAssignee() != null) {
                existingJob.setTaAssignee(jobDTO.getTaAssignee());
            }
            if (jobDTO.getLocation() != null) {
                existingJob.setLocation(jobDTO.getLocation());
            }
            if (jobDTO.getCreateDate() != null) {
                existingJob.setCreateDate(jobDTO.getCreateDate());
            }
            if (jobDTO.getNoOfSubmission() > 0) {
                existingJob.setNoOfSubmission(jobDTO.getNoOfSubmission());
            }
            if (jobDTO.getVendor() != null) {
                existingJob.setVendor(jobDTO.getVendor());
            }
            if (jobDTO.getWorkExperience() > 0) {
                existingJob.setWorkExperience(jobDTO.getWorkExperience());
            }
            if (jobDTO.getNoOfPositions() > 0) {
                existingJob.setNoOfPositions(jobDTO.getNoOfPositions());
            }
            if (jobDTO.getTargetDate() != null) {
                existingJob.setTargetDate(jobDTO.getTargetDate());
            }
            if (jobDTO.getWorkType() != null) {
                existingJob.setWorkType(jobDTO.getWorkType());
            }
            if (jobDTO.getLanguagesRequired() != null) {
                existingJob.setLanguagesRequired(jobDTO.getLanguagesRequired());
            }
            if (jobDTO.getQualifications() != null) {
                existingJob.setQualifications(jobDTO.getQualifications());
            }
            if (jobDTO.getIndustry() != null) {
                existingJob.setIndustry(jobDTO.getIndustry());
            }
            if (jobDTO.getPriority() != null) {
                existingJob.setPriority(jobDTO.getPriority());
            }
            if (jobDTO.getProjectId() != null) {
                existingJob.setProjectId(jobDTO.getProjectId());
            }
            if (jobDTO.getClientJobId() != null) {
                existingJob.setClientJobId(jobDTO.getClientJobId());
            }
            if (jobDTO.getAccountManager() != null) {
                existingJob.setAccountManager(jobDTO.getAccountManager());
            }

            JobsEntity updatedEntity = jobRepository.save(existingJob);
            return new ApiResponse(true, "Job updated successfully",
                    mapperConfig.toDtoJob(updatedEntity), null);
        } else {
            throw new EntityNotFoundException("Job with ID " + id + " not found");
        }
    }


    // Soft Delete Job
    @Override
    @Transactional
    public ApiResponse softDeleteJob(Long jobId) {
        Optional<JobsEntity> jobOptional = jobRepository.findById(jobId);
        if (jobOptional.isEmpty()) {
            throw new EntityNotFoundException("Job not found with ID: " + jobId);
        }
        jobRepository.softDeleteJob(jobId);
        return new ApiResponse(true, "Soft delete success", null, null);
    }

    // Get All Jobs with Pagination
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
        return new ApiResponse(true, "Jobs retrieved successfully", null, paginationResponse);
    }

    // Global Search for Jobs by jobCode
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

        if (jobDTOs.isEmpty()) {
            return new ApiResponse(false, "No jobs found matching the criteria", null, paginationResponse);
        }

        return new ApiResponse(true, "Jobs found", null, paginationResponse);
    }
}
