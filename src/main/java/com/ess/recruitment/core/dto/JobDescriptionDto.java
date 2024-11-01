package com.ess.recruitment.core.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDescriptionDto {
    private Long id;
    private Long jobDomain;
    private Long jobDescription;
    private String recruiterInstructions;
    private Long jobId;
}
