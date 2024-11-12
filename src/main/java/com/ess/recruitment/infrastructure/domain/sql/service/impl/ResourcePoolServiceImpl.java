package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.PaginationResponse;
import com.ess.recruitment.core.resp.RecruitmentCountResponse;
import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.ResourcePoolRepository;
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
public class ResourcePoolServiceImpl implements ResourcePoolService {
    @Autowired
    ResourcePoolRepository resourcePoolRepository;
    @Autowired
    MapperConfig mapperConfig;

    private <T> PaginationResponse<T> createPaginationResponse(Page<T> page) {
        return new PaginationResponse<>(
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getSize(),
                page.getContent()
        );
    }

    @Override
    @Transactional
    public ApiResponse createResourcePool(RecruitmentRequest recruitmentRequest) {
        try {
            Optional<ResourcePoolEntity> latestResource = resourcePoolRepository.findTopByOrderByResourceCodeDesc();

            // Check if latestResource is present and has a non-null resourceCode
            String resourcePoolCode = latestResource
                    .filter(resource -> resource.getResourceCode() != null)
                    .map(resource -> {
                        System.out.println("Latest code: " + resource.getResourceCode());
                        String latestCodePart = resource.getResourceCode().substring(9);
                        int nextCodeNumber = Integer.parseInt(latestCodePart) + 1;
                         return "RESOURCE-" + String.format("%03d", nextCodeNumber);
                    })
                    .orElse("RESOURCE-001");

            ResourcePoolEntity resourcePoolEntity = mapperConfig.toEntityResource(recruitmentRequest.getResourcePoolDto());
            resourcePoolEntity.setResourceCode(resourcePoolCode);

            ResourcePoolEntity savedEntity = resourcePoolRepository.save(resourcePoolEntity);
            return new ApiResponse(true, "Resource created successfully",
                    mapperConfig.toDtoResource(savedEntity), null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create Resource: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public ApiResponse getResourceById(Long id) {
        return resourcePoolRepository.findById(id)
                .map(entity -> new ApiResponse(true, "Resource found", mapperConfig.toDtoResource(entity), null))
                .orElseThrow(() -> new EntityNotFoundException("Resource with ID " + id + " not found"));
    }

    @Override
    @Transactional
    public ApiResponse getAllResourcesWithCounts() {
        long activeCount = resourcePoolRepository.countByDelFlag(1);
        long inactiveCount = resourcePoolRepository.countByDelFlag(0);

        long yetToStartCount = resourcePoolRepository.countByStatus(Status.YET_TO_START);
        long onGoingCount = resourcePoolRepository.countByStatus(Status.ONGOING);
        long openCount = resourcePoolRepository.countByStatus(Status.ACTIVE);
//        long closedCount = jobRepository.countByStatus(Status.IN_ACTIVE);
        long completeCount = resourcePoolRepository.countByStatus(Status.COMPLETE);

        activeCount=yetToStartCount+openCount+onGoingCount;
        inactiveCount=completeCount;

        long totalCount = resourcePoolRepository.count();

        RecruitmentCountResponse response = new RecruitmentCountResponse(
                totalCount,activeCount,inactiveCount,openCount,yetToStartCount,onGoingCount,completeCount);

        return new ApiResponse(true, "Getting all resources", response, null);
    }

    @Override
    public ApiResponse updateResourceStatus(Long id, RecruitmentRequest recruitmentRequest) {
        Optional<ResourcePoolEntity> optionalResourcePool = resourcePoolRepository.findById(id);
        if (optionalResourcePool.isPresent()) {
            ResourcePoolEntity existingResource = optionalResourcePool.get();
            ResourcePoolDto resourcePoolDto = recruitmentRequest.getResourcePoolDto();

            if (resourcePoolDto.getResourceCode() != null) {
                existingResource.setResourceCode(resourcePoolDto.getResourceCode());
            }
            if (resourcePoolDto.getResourcePoolId() != null) {
                existingResource.setPoolId(resourcePoolDto.getResourcePoolId());
            }
            if (resourcePoolDto.getPoolId() != null) {
                existingResource.setPoolId(resourcePoolDto.getPoolId());
                existingResource.setDelFlag(resourcePoolDto.getPoolId().equals(Status.COMPLETE) ? 0 : 1);
            }
            ResourcePoolEntity updatedEntity = resourcePoolRepository.save(existingResource);
            return new ApiResponse(true, "Resource updated successfully",
                    mapperConfig.toDtoResource(updatedEntity), null);
        } else {
            throw new EntityNotFoundException("Resource with ID " + id + " not found");
        }
    }

    @Override
    public ApiResponse softDeleteResource(Long resourceId) {
        Optional<ResourcePoolEntity> resourcePoolEntityOptional = resourcePoolRepository.findById(resourceId);
        if (resourcePoolEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Resource not found with ID: " + resourceId);
        }
        resourcePoolRepository.softDeleteResource(resourceId,Status.COMPLETE);
        return new ApiResponse(true,"soft delete success",null,null);

    }

    @Override
    public ApiResponse getAllResource(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page,pageSize);
        Page<ResourcePoolEntity> resourcePage=resourcePoolRepository.findAll(pageable);
        List<ResourcePoolDto> resources=resourcePage.getContent().stream().map(mapperConfig::toDtoResource).collect(Collectors.toList());
        PaginationResponse<ResourcePoolDto> paginationResponse = new PaginationResponse<>(
                resourcePage.getTotalPages(),
                resourcePage.getNumber(),
                resourcePage.getTotalElements(),
                resourcePage.getSize(),
                resources
        );
        return new ApiResponse(true, "resources retrieved successfully", null, paginationResponse);
    }

    @Override
    public ApiResponse globalSearch(String searchKey, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<ResourcePoolEntity> resourcePoolEntities = resourcePoolRepository.globalSearch(searchKey, pageable);

        List<ResourcePoolDto> resourcePoolDtos = resourcePoolEntities.getContent().stream()
                .map(mapperConfig::toDtoResource)
                .collect(Collectors.toList());

        PaginationResponse<ResourcePoolDto> paginationResponse = new PaginationResponse<>(
                resourcePoolEntities.getTotalPages(),
                resourcePoolEntities.getNumber(),
                resourcePoolEntities.getTotalElements(),
                resourcePoolEntities.getSize(),
                resourcePoolDtos
        );
        if (resourcePoolDtos.isEmpty()) {
            return new ApiResponse(false, "No resources found matching the criteria", null, paginationResponse);
        }
        return new ApiResponse(true, "resources found", null, paginationResponse);
    }
}