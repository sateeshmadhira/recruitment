package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.ResourcePoolDto;

import java.util.List;

public interface ResourcePoolService {
    ResourcePoolDto createResourcePool(ResourcePoolDto resourcePoolDto);
    List<ResourcePoolDto> getAll();
    ResourcePoolDto getById(Long resourcePoolId);
}
