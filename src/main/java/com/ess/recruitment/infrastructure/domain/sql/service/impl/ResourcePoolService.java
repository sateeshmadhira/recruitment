package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;

public interface ResourcePoolService {
    ApiResponse createResourcePool(RecruitmentRequest recruitmentRequest);
    ApiResponse getResourceById(Long id);
    ApiResponse getAllResourcesWithCounts();
    ApiResponse updateResourceStatus(Long id, RecruitmentRequest recruitmentRequest);
    ApiResponse softDeleteResource(Long resourcePoolId);
    ApiResponse getAllResource(int page, int pageSize);
    ApiResponse globalSearch(String searchKey, int page, int pageSize);
}
