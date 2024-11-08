package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.dto.RecruitmentTeamDto;
import com.ess.recruitment.core.utils.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class JobsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_ID")
    private Long jobId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Column(name = "PRIMARY_SKILLS")
    private String primarySkills;

    @Column(name = "SECONDARY_SKILLS")
    private String secondarySkills;

    @Column(name = "CITY")
    private String city;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "WORK_EXPERIENCE")
    private int workExperience;

    @Column(name = "NO_OF_POSITIONS")
    private int noOfPositions;

    @Column(name = "TARGET_DATE")
    private Date targetDate;

    @Enumerated(EnumType.STRING)
    private RemoteStatus remoteStatus;

    @Column(name = "LANGUAGES_REQUIRED")
    private String languagesRequired;

    @Enumerated(EnumType.STRING)
    private Qualifications qualifications;

    @Enumerated(EnumType.STRING)
    private Industry industry;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "PROJECT_ID")
    private String projectId;

    @Column(name = "CLIENT_JOB_ID")
    private String clientJobId;

    @Enumerated(EnumType.STRING)
    private PayType payType;
    @Column(name = "CTC")
    private String ctc;
    @Column(name = "CONTRACTPERIOD")
    private String contractPeriod;
    @Column(name = "MARKASPREFERRED")
    private boolean markAsPreferred;
    @Enumerated(EnumType.STRING)
    private RecruitmentTeamDto recruitmentTeam;
    @Enumerated(EnumType.STRING)
    private Recruiters recruiters;
    @Enumerated(EnumType.STRING)
    private AdditionalRecruiters additionalReccruiters;
    @Enumerated(EnumType.STRING)
    private RecruitmentManager recruitmentManager;
    @Enumerated(EnumType.STRING)
    private DropDown dropDown;
    @Enumerated(EnumType.STRING)
    private AccountManager accountManager;
    @Column(name = "MAX_SUBMISSIONS")
    private String maximumSubmissions;
    @Enumerated(EnumType.STRING)
    private InterviewPanel interviewPanel;
    @Enumerated(EnumType.STRING)
    private JobDescription jobDescription;
    @Enumerated(EnumType.STRING)
    private JobDomain jobDomain;
    @Column(name = "RECRUITERINSTRUCTIONS")
    private String recruiterInstructions;
    @Enumerated(EnumType.STRING)
    private Attachments attachments;


    private JobDescriptionDTO jobDescriptionDTO;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private PayAndBillingDetailsEntity payAndBillingDetailsEntity;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private RecruitmentTeamEntity recruitmentTeamEntity;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private JobDescriptionEntity jobDescriptionEntity;
}
