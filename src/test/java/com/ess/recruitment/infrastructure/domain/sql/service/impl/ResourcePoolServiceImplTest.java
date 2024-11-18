package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.ResourcePoolRepository;
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

class ResourcePoolServiceImplTest {
    @Mock
    ResourcePoolRepository  resourcePoolRepository;

    @Mock
    MapperConfig mapperConfig;

    @InjectMocks
    ResourcePoolServiceImpl resourcePoolService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createResourcePoolSuccess(){
        RecruitmentRequest request=new RecruitmentRequest(new ResourcePoolDto());
        ResourcePoolEntity resourcePoolEntity=new ResourcePoolEntity();
        resourcePoolEntity.setResourceCode("RES-001");
        when(mapperConfig.toEntityResource(request.getResourcePoolDto())).thenReturn(resourcePoolEntity);
        when(resourcePoolRepository.save(any(ResourcePoolEntity.class))).thenReturn(resourcePoolEntity);

        ApiResponse response=resourcePoolService.createResourcePool(request);

        assertTrue(response.isSuccess());
        assertEquals("ResourcePool created successfully",response.getMessage());


    }
    @Test
    void createResourcePoolFail(){
        RecruitmentRequest request=new RecruitmentRequest(new CandidateSubmissionDto());
        when(mapperConfig.toEntityResource(request.getResourcePoolDto())).thenThrow(new RuntimeException("Mapping Error"));

        assertThrows(IllegalArgumentException.class,()->resourcePoolService.createResourcePool(request));
    }

    @Test
    void getResourcePoolId_ShouldReturnApiResponse_whenResourcePoolExist(){
        Long resourcePoolId=1L;
        ResourcePoolEntity resourcePoolEntity=new ResourcePoolEntity();
        when(resourcePoolRepository.findById(resourcePoolId)).thenReturn(Optional.of(resourcePoolEntity));
        when(mapperConfig.toDtoResource(resourcePoolEntity)).thenReturn(new ResourcePoolDto());

        ApiResponse response=resourcePoolService.getResourceById(resourcePoolId);

        assertTrue(response.isSuccess());
        assertEquals("ResourcePool found",response.getMessage());

    }

    @Test
    void getCandidateId_ShouldThrowException_whenCandidateNotFound(){
        Long resourcePoolId=1L;
        when(resourcePoolRepository.findById(resourcePoolId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,()->resourcePoolService.getResourceById(resourcePoolId));


    }
    @Test
    void updateResourcePoolStatus_ShouldUpdateSuccesssfully(){
        Long resourcePoolId=1L;
        RecruitmentRequest request=new RecruitmentRequest();
        ResourcePoolEntity resourcePoolEntity=new ResourcePoolEntity();
        when(resourcePoolRepository.findById(resourcePoolId)).thenReturn(Optional.of(resourcePoolEntity));
        when(resourcePoolRepository.save(resourcePoolEntity)).thenReturn(resourcePoolEntity);

        ApiResponse response=resourcePoolService.updateResourceStatus(resourcePoolId,request);

        assertTrue(response.isSuccess());
        assertEquals("ResourcePool updated successfully",response.getMessage());
    }

    @Test
    void updateResourcePoolStatus_ShouldThrowException_whenResourcePoolNotUpdate() {
        Long resourcePoolId = 1L;
        when(resourcePoolRepository.findById(resourcePoolId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> resourcePoolService.updateResourceStatus(resourcePoolId, new RecruitmentRequest()));

    }
}