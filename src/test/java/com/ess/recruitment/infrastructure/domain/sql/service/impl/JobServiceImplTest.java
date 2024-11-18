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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class JobServiceImplTest {

    @Mock
    JobRepository jobRepository;

    @Mock
    MapperConfig mapperConfig;

    @InjectMocks
    JobServiceImpl jobService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createJobSubmissionSuccess() {
        RecruitmentRequest request = new RecruitmentRequest(new JobsDTO());
        JobsEntity jobsEntity = new JobsEntity();
        jobsEntity.setJobCode("JOB-001");
        when(mapperConfig.toEntityJob(request.getJobsDTO())).thenReturn(jobsEntity);
        when(jobRepository.save(any(JobsEntity.class))).thenReturn(jobsEntity);

        ApiResponse response = jobService.createJob(request);

        assertTrue(response.isSuccess());
        assertEquals("job created successfully", response.getMessage());
    }
    @Test
    void createJobFail() {
        RecruitmentRequest request = new RecruitmentRequest(new JobsDTO());
        when(mapperConfig.toEntityJob(request.getJobsDTO())).thenThrow(new RuntimeException("Mapping Error"));

        assertThrows(IllegalArgumentException.class, () -> jobService.createJob(request));
    }

    @Test
    void getJobId_ShouldReturnApiResponse_whenJobExist(){
        Long jobId=1L;
        JobsEntity jobsEntity=new JobsEntity();
        when(jobRepository.findById(jobId)).thenReturn(Optional.of(jobsEntity));
        when(mapperConfig.toDtoJob(jobsEntity)).thenReturn(new JobsDTO());

        ApiResponse response=jobService.getJobById(jobId);

        assertTrue(response.isSuccess());
        assertEquals("jobs found",response.getMessage());

    }

    @Test
    void getJobId_ShouldThrowException_whenJobNotFound(){
        Long jobId=1L;
        when(jobRepository.findById(jobId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,()->jobService.getJobById(jobId));

    }
    @Test
    void updateJobStatus_ShouldUpdateSuccesssfully(){
        Long jobId=1L;
        RecruitmentRequest request=new RecruitmentRequest();
        JobsEntity jobsEntity=new JobsEntity();
        when(jobRepository.findById(jobId)).thenReturn(Optional.of(jobsEntity));
        when(jobRepository.save(jobsEntity)).thenReturn(jobsEntity);

        ApiResponse response=jobService.updateJobStatus(jobId,request);

        assertTrue(response.isSuccess());
        assertEquals("getting all jobs",response.getMessage());
    }

    @Test
    void updateJobStatus_ShouldThrowException_whenJobNotUpdate(){
        Long jobId=1L;
        when(jobRepository.findById(jobId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,()->jobService.updateJobStatus(jobId,new RecruitmentRequest()));

    }
}