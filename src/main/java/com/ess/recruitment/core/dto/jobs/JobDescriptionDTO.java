package com.ess.recruitment.core.dto.jobs;

import com.ess.recruitment.core.utils.Industry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDescriptionDTO {

    private Long id;
    private Industry jobDomain;
    private String jobDescription;
    private String recruiterInstructions;
    private Long jobId;
}
