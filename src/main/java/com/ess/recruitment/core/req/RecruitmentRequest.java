package com.ess.recruitment.core.req;


import com.ess.recruitment.core.dto.jobs.JobsDTO;
import com.ess.recruitment.core.dto.template.TemplateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentRequest extends ReqFilter {
    private TemplateDTO templateDTO=new TemplateDTO();
    private JobsDTO jobsDTO=new JobsDTO();

}
