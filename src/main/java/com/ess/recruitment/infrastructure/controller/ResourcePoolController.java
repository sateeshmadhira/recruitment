package com.ess.recruitment.infrastructure.controller;

import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.req.SearchReq;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.ResourcePoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resourcepool")
@CrossOrigin("*")
public class ResourcePoolController {

    @Autowired
    ResourcePoolService resourcePoolService;

    @PostMapping("/saveResource")
    public ResponseEntity<ApiResponse> createResourcePool(@RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = resourcePoolService.createResourcePool(recruitmentRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getResourceById(@PathVariable("id") Long id) {
        ApiResponse apiResponse = resourcePoolService.getResourceById(id);
        return ResponseEntity.ok(apiResponse);
    }

    // Get All Jobs with Counts
    @GetMapping("/counts")
    public ResponseEntity<ApiResponse> getAllResourcesWithCounts() {
        ApiResponse response = resourcePoolService.getAllResourcesWithCounts();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateResourceStatus(@PathVariable("id") Long id, @RequestBody RecruitmentRequest recruitmentRequest) {
        ApiResponse response = resourcePoolService.updateResourceStatus(id, recruitmentRequest);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> softDeleteResource(@PathVariable("id") Long resourcePoolId) {
        ApiResponse response = resourcePoolService.softDeleteResource(resourcePoolId);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllResource(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize){
        ApiResponse response=resourcePoolService.getAllResource(page,pageSize);
        return response.isSuccess() ? ResponseEntity.ok(response) : ResponseEntity.status(404).body(response);
    }
    @PostMapping("/search")
    public ResponseEntity<ApiResponse> globalSearch(@RequestBody SearchReq searchReq) {
        ApiResponse response = resourcePoolService.globalSearch(
                searchReq.getSearchKey(),
                searchReq.getPage(),
                searchReq.getPageSize()
        );
        return ResponseEntity.ok(response);
    }
}