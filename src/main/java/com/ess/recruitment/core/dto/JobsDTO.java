package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobsDTO {
    private  String jobId;
    private Status status;
    private String jobTitle;
    private CustomerType customerType;
    private String primarySkills;
    private String secondarySkills;
    private String city;
    private Country country;
    private State state;
    private int workExperience;
    private String noOfPositions;
    private Date targetDate;
    private RemoteStatus remoteStatus;
    private String languageRequired;
    private String qualification;
    private Industry industry;
    private Priority priority;
    private ProjectName projectName;
    private String projectId;
    private String clintJobId;
    private PayAndBillingDetailsDTO payAndBillingDetailsDto;
    private JobType jobType;
    private PayType payType;
    private String ctc;
    private String contractPeriod;
    private boolean markAsPreferred;
    private RecruitmentTeamDto recruitmentTeam;
    private Recruiters recruiters;
    private AdditionalRecruiters additionalReccruiters;
    private RecruitmentManager recruitmentManager;
    private DropDown dropDown;
    private AccountManager accountManager;
    private String maximumSubmissions;
    private InterviewPanel interviewPanel;
    private JobDescription jobDescription;
    private JobDomain jobDomain;
    private String recruiterInstructions;
    private Attachments attachments;
    private JobDescriptionDTO jobDescriptionDTO;

}
