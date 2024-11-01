package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobsDto {
    private String jobId;
    private Status status;
    private String jobTitle;
    private JobType jobType;
    private String primarySkills;
    private String secondarySkills;
    private String city;
    private Country country;
    private State state;
    private int workExperience;
    private int noOfPositions;
    private Date targetDate;
    private RemoteStatus remoteStatus;
    private String languagesRequired;
    private Qualification qualifications;
    private Industry industry;
    private Priority priority;
    private String projectName;
    private String projectId;
    private String clientJobId;
    private PayAndBillingDetailsDto payAndBillingDetailsDTO;
    private RecruitmentTeamDto recruitmentTeamDTO;
    private JobDescriptionDto jobDescriptionDTO;
}
