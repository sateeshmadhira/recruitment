package com.ess.recruitment.core.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDescriptionDTO {
    private Long id;
    private Long jobDomain;
    private Long jobDescription;
    private String recruiterInstructions;
    private Long jobId;
}
