package com.ess.recruitment.infrastructure.domain.sql.model.jobs;

import com.ess.recruitment.core.utils.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class JobsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_ID")
    private Long jobId;

    @Column(name = "JOB_CODE")
    private String jobCode;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "IS_ACTIVE")
    private Integer delFlag = 1;  // Default to active

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    @ElementCollection
    @Column(name = "PRIMARY_SKILLS")
    private List<String> primarySkills;

    @ElementCollection
    @Column(name = "SECONDARY_SKILLS")
    private List<String> secondarySkills;

    @Column(name = "WORK_EXPERIENCE")
    private int workExperience;

    @Column(name = "NO_OF_POSITIONS")
    private int noOfPositions;

    @Column(name = "TECHNOLOGY")
    private String technology;

    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;

    @Column(name = "REL_EXP")
    private int relevantExperience;

    @Column(name = "DOMAIN")
    private String domain;

    @Column(name = "PAY_RATE")
    private String payRate;

    @Column(name = "TA_ASSIGNEE")
    private String taAssignee;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "TARGET_DATE")
    private Date targetDate;

    @Enumerated(EnumType.STRING)
    private WorkType workType;

    @Column(name = "LANGUAGES_REQUIRED")
    private String languagesRequired;


    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "PROJECT_ID")
    private String projectId;

    @Column(name = "CLIENT_JOB_ID")
    private String clientJobId;

    @Column(name = "NO_OF_SUBMISSION")
    private int noOfSubmission;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "ACCOUNT_MANAGER")
    private List<String> accountManager;

}
