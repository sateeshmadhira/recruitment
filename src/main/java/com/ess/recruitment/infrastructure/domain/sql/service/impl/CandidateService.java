package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;

import java.util.List;

public interface CandidateService {

    CandidateSubmissionDto createCandidate(CandidateSubmissionDto candidateDto);

    List<CandidateSubmissionDto> getAll();

    CandidateSubmissionDto getById(Long id);

    CandidateSubmissionDto updateCandidate(Long id, CandidateSubmissionDto candidateSubmissionDto);


}
