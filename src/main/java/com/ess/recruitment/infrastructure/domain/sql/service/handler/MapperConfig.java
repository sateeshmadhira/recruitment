package com.ess.recruitment.infrastructure.domain.sql.service.handler;

import com.ess.recruitment.core.dto.CandidateSubmissionDto;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import org.springframework.stereotype.Component;

@Component
public interface MapperConfig {


    CandidateSubmissionDto toCandidateDTO(CandidateSubmissionEntity entity);

    CandidateSubmissionEntity toCandidateEntity(CandidateSubmissionDto dto);


}
