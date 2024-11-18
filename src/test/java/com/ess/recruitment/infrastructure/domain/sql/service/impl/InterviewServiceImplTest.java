package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.InterviewDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.InterviewEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.InterviewRepository;
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

class InterviewServiceImplTest {

    @Mock
    InterviewRepository interviewRepository;

    @Mock
    MapperConfig mapperConfig;

    @InjectMocks
    InterviewServiceImpl interviewService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createInterviewSuccess(){
        RecruitmentRequest request=new RecruitmentRequest(new InterviewDto());
        InterviewEntity interviewEntity=new InterviewEntity();
        interviewEntity.setInterviewCode("INT-001");
        when(mapperConfig.toInterviewEntity(request.getInterviewDto())).thenReturn(interviewEntity);
        when(interviewRepository.save(any(InterviewEntity.class))).thenReturn(interviewEntity);

        ApiResponse response=interviewService.createInterivew(request);

        assertTrue(response.isSuccess());
        assertEquals("Interview created successfully",response.getMessage());


    }
    @Test
    void createTemplateFail(){
        RecruitmentRequest request=new RecruitmentRequest(new InterviewDto());
        when(mapperConfig.toInterviewEntity(request.getInterviewDto())).thenThrow(new RuntimeException("Mapping Error"));

        assertThrows(IllegalArgumentException.class,()->interviewService.createInterivew(request));
    }

    @Test
    void getInterviewId_ShouldReturnApiResponse_whenInterviewExist(){
        Long interviewId=1L;
        InterviewEntity interviewEntity=new InterviewEntity();
        when(interviewRepository.findById(interviewId)).thenReturn(Optional.of(interviewEntity));
        when(mapperConfig.toInterviewDto(interviewEntity)).thenReturn(new InterviewDto());

        ApiResponse response=interviewService.getInterviewById(interviewId);

        assertTrue(response.isSuccess());
        assertEquals("interview found",response.getMessage());

    }

    @Test
    void getInerviewId_ShouldThrowException_whenInterviewNotFound(){
        Long interviewId=1L;
        when(interviewRepository.findById(interviewId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,()->interviewService.getInterviewById(interviewId));


    }
    @Test
    void updateInterviewStatus_ShouldUpdateSuccesssfully(){
        Long interviewId=1L;
        RecruitmentRequest request=new RecruitmentRequest();
        InterviewEntity interviewEntity=new InterviewEntity();
        when(interviewRepository.findById(interviewId)).thenReturn(Optional.of(interviewEntity));
        when(interviewRepository.save(interviewEntity)).thenReturn(interviewEntity);

        ApiResponse response=interviewService.updateInterviewStatus(interviewId,request);

        assertTrue(response.isSuccess());
        assertEquals("Interview updated successfully",response.getMessage());
    }

    @Test
    void updateInterviewStatus_ShouldThrowException_whenInterviewNotUpdate(){
        Long interviewId=1L;
        when(interviewRepository.findById(interviewId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,()->interviewService.updateInterviewStatus(interviewId,new RecruitmentRequest()));


    }



}