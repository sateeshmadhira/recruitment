package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.dto.JobDescriptionDTO;
import com.ess.recruitment.core.dto.PayAndBillingDetailsDTO;
import com.ess.recruitment.core.dto.RecruitmentTeamDTO;
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

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private PayAndBillingDetailsEntity payAndBillingDetailsEntity;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private RecruitmentTeamEntity recruitmentTeamEntity;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private JobDescriptionEntity jobDescriptionEntity;
}
