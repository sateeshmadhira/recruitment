package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.JobsDTO;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.JobRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JobServiceImplTest {

    @Mock
    private JobRepository jobRepository;

    @Mock
    private MapperConfig mapperConfig;

    @InjectMocks
    private JobServiceImpl jobService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test cases for createJob
    @Test
    void createJob_ShouldReturnApiResponse_OnSuccess() {
        RecruitmentRequest request = new RecruitmentRequest(new JobsDTO());
        JobsEntity entity = new JobsEntity();
        entity.setJobCode("JOB-001");
        when(mapperConfig.toEntityJob(request.getJobsDTO())).thenReturn(entity);
        when(jobRepository.save(any(JobsEntity.class))).thenReturn(entity);
        ApiResponse response = jobService.createJob(request);
        assertTrue(response.isSuccess());
        assertEquals("Job created successfully", response.getMessage());
    }

    @Test
    void createJob_ShouldThrowException_OnFailure() {
        RecruitmentRequest request = new RecruitmentRequest(new JobsDTO());
        when(mapperConfig.toEntityJob(request.getJobsDTO())).thenThrow(new RuntimeException("Mapping error"));

        assertThrows(IllegalArgumentException.class, () -> jobService.createJob(request));
    }


    @Test
    void getJobId_ShouldReturnApiResponse_WhenJobExists() {
        Long jobId = 1L;
        JobsEntity entity = new JobsEntity();
        when(jobRepository.findById(jobId)).thenReturn(Optional.of(entity));
        when(mapperConfig.toDtoJob(entity)).thenReturn(new JobsDTO());

        ApiResponse response = jobService.getJobById(jobId);

        assertTrue(response.isSuccess());
        assertEquals("Job found", response.getMessage());
    }

    @Test
    void getJobById_ShouldThrowEntityNotFoundException_WhenJobNotFound() {
        Long jobId = 1L;
        when(jobRepository.findById(jobId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> jobService.getJobById(jobId));
    }

    // Test cases for updateJobStatus
    @Test
    void updateJobStatus_ShouldUpdateStatusSuccessfully() {
        Long jobId = 1L;
        RecruitmentRequest request = new RecruitmentRequest(new JobsDTO());
        JobsEntity entity = new JobsEntity();
        when(jobRepository.findById(jobId)).thenReturn(Optional.of(entity));
        when(jobRepository.save(entity)).thenReturn(entity);

        ApiResponse response = jobService.updateJobStatus(jobId, request);

        assertTrue(response.isSuccess());
        assertEquals("Job updated successfully", response.getMessage());
    }

    @Test
    void updateStatus_ShouldThrowEntityNotFoundException_WhenJobNotFound() {
        Long jobId = 1L;
        when(jobRepository.findById(jobId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> jobService.updateJobStatus(jobId,new RecruitmentRequest()));
    }

}