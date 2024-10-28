package com.ess.recruitment.core.dto;

import lombok.Data;

@Data
public class JobRelatedDto {
    private int workExperienceYears;
    private int numberOfPositions;
    private String primarySkills;
    private String secondarySkills;
    private String remoteStatus;
}
