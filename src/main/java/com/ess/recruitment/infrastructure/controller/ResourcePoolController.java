package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.ResourcePoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ResourcePool")
@CrossOrigin("*")
public class ResourcePoolController {
    @Autowired
    ResourcePoolService resourcePoolService;

    @PostMapping
    public ResponseEntity<ResourcePoolDto>createResourcePool(@RequestBody ResourcePoolDto resourcePoolDto){
        ResourcePoolDto dto=resourcePoolService.createResourcePool(resourcePoolDto);
        return ResponseEntity.ok(dto);
    }
    @GetMapping(value="/{poolId}")
    public ResponseEntity<ResourcePoolDto>getById(@PathVariable("poolId") Long resourcePoolId){
        ResourcePoolDto dto=resourcePoolService.getById(resourcePoolId);
        return ResponseEntity.ok(dto);
    }
}