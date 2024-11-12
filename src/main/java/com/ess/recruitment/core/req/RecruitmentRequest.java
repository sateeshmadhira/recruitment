package com.ess.recruitment.core.req;


import com.ess.recruitment.core.dto.CandidateSubmissionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentRequest extends ReqFilter {
    private CandidateSubmissionDto candidateSubmissionDto  = new CandidateSubmissionDto();
}
