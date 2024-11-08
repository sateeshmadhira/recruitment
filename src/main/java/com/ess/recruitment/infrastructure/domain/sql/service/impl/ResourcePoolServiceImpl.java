package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import com.ess.recruitment.infrastructure.domain.sql.repo.ResourcePoolRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourcePoolServiceImpl implements ResourcePoolService{
    @Autowired
    ResourcePoolRepository resourcePoolRepository;
    @Autowired
    MapperConfig mapperConfig;

    @Override
    public ResourcePoolDto createResourcePool(ResourcePoolDto resourcePoolDto) {
        ResourcePoolEntity resourcePoolEntity=mapperConfig.toEntity(resourcePoolDto);
        ResourcePoolEntity saveResourcePoolEntity=resourcePoolRepository.save(resourcePoolEntity);
        ResourcePoolDto saveDto=mapperConfig.toDto(saveResourcePoolEntity);
        return saveDto;
    }

    @Override
    public List<ResourcePoolDto> getAll() {
        List<ResourcePoolEntity> resourcePoolEntities = resourcePoolRepository.findAll();
        List<ResourcePoolDto> resourcePoolDtoList = new ArrayList<>();
        for(ResourcePoolEntity resourcePoolEntity1: resourcePoolEntities){
            ResourcePoolDto resourcePoolDto = mapperConfig.toDto(resourcePoolEntity1);
            resourcePoolDtoList.add(resourcePoolDto);
        }
        return resourcePoolDtoList;
    }

    @Override
    public ResourcePoolDto getById(Long resourcePoolId) {
         return resourcePoolRepository.findById(resourcePoolId).map(entity ->
                 mapperConfig.toDto(entity)).orElseThrow(()-> new RuntimeException("pool with id "+resourcePoolId+"not found"));
    }
}
