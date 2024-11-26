package com.ess.recruitment.core.req;


import com.ess.recruitment.core.dto.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentRequest extends ReqFilter {

    private JobsDTO jobsDTO=new JobsDTO();
    private InterviewDto interviewDto=new InterviewDto();
    private ResourcePoolDto resourcePoolDto=new ResourcePoolDto();
    private CandidateSubmissionDto candidateSubmissionDto  = new CandidateSubmissionDto();
    private TemplateDTO templateDTO=new TemplateDTO();
    public RecruitmentRequest(JobsDTO jobsDTO){

    }
}
