package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.core.req.RecruitmentRequest;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;

public interface CandidateService {

    ApiResponse createCandidate(RecruitmentRequest recruitmentRequest);

    ApiResponse getCandidateById(Long id);

    ApiResponse getAllCandidatesWithCounts();

    ApiResponse updateCandidateStatus(Long id, RecruitmentRequest recruitmentRequest);

    ApiResponse softDeleteCandidate(Long candidateId);

    ApiResponse getAllCandidates(int page, int pageSize);

    ApiResponse globalSearch(String searchKey, int page, int pageSize);
}
