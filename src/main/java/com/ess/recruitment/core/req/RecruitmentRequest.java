package com.ess.recruitment.core.req;


import com.ess.recruitment.core.dto.ResourcePoolDto;
import com.ess.recruitment.core.dto.jobs.JobsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentRequest extends ReqFilter {

    private JobsDTO jobsDTO=new JobsDTO();
    private ResourcePoolDto resourcePoolDto=new ResourcePoolDto();
}
