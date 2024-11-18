package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.CandidateSubmissionRepository;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CandidateServiceImplTest {



    @Mock
    CandidateSubmissionRepository candidateSubmissionRepository;

    @Mock
    MapperConfig mapperConfig;

    @InjectMocks
    CandidateServiceImpl candidateService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCandidateSubmissionSuccess(){
        RecruitmentRequest request=new RecruitmentRequest(mock(CandidateSubmissionDto.class));
        CandidateSubmissionEntity candidateSubmissionEntity=new CandidateSubmissionEntity();
        candidateSubmissionEntity.setCandidateCode("CAN-001");
        when(mapperConfig.toCandidateEntity(request.getCandidateSubmissionDto())).thenReturn(candidateSubmissionEntity);
        when(candidateSubmissionRepository.save(any(CandidateSubmissionEntity.class))).thenReturn(candidateSubmissionEntity);

        ApiResponse response=candidateService.createCandidate(request);

        assertTrue(response.isSuccess());
        assertEquals("Candidate created successfully",response.getMessage());


    }
    @Test
    void createTemplateFail(){
        RecruitmentRequest request=new RecruitmentRequest(new CandidateSubmissionDto());
        when(mapperConfig.toCandidateEntity(request.getCandidateSubmissionDto())).thenThrow(new RuntimeException("Mapping Error"));

        assertThrows(IllegalArgumentException.class,()->candidateService.createCandidate(request));
    }

    @Test
    void getCandidateId_ShouldReturnApiResponse_whenCandidateExist(){
        Long candidateId=1L;
        CandidateSubmissionEntity candidateSubmissionEntity=new CandidateSubmissionEntity();
        when(candidateSubmissionRepository.findById(candidateId)).thenReturn(Optional.of(candidateSubmissionEntity));
        when(mapperConfig.toCandidateDTO(candidateSubmissionEntity)).thenReturn(new CandidateSubmissionDto());

        ApiResponse response=candidateService.getCandidateById(candidateId);

        assertTrue(response.isSuccess());
        assertEquals("candidate found",response.getMessage());

    }

    @Test
    void getCandidateId_ShouldThrowException_whenCandidateNotFound(){
        Long candidateId=1L;
        when(candidateSubmissionRepository.findById(candidateId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,()->candidateService.getCandidateById(candidateId));


    }
    @Test
    void updateCandidateStatus_ShouldUpdateSuccesssfully(){
        Long candidateId=1L;
        RecruitmentRequest request=new RecruitmentRequest();
        CandidateSubmissionEntity candidateSubmissionEntity=new CandidateSubmissionEntity();
        when(candidateSubmissionRepository.findById(candidateId)).thenReturn(Optional.of(candidateSubmissionEntity));
        when(candidateSubmissionRepository.save(candidateSubmissionEntity)).thenReturn(candidateSubmissionEntity);

        ApiResponse response=candidateService.updateCandidateStatus(candidateId,request);

        assertTrue(response.isSuccess());
        assertEquals("canditate updated success",response.getMessage());
    }

    @Test
    void updateCandidateStatus_ShouldThrowException_whenCandidateNotUpdate(){
        Long candidateId=1L;
        when(candidateSubmissionRepository.findById(candidateId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,()->candidateService.updateCandidateStatus(candidateId,new RecruitmentRequest()));

    }

}