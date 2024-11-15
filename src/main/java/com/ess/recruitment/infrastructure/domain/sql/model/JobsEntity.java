package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Job code must not be empty")
    @Column(name = "JOB_CODE")
    private String jobCode;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotBlank(message = "Job title must not be empty")
    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @NotNull(message = "Active status must be specified")
    @Column(name = "IS_ACTIVE")
    private Integer delFlag = 1;  // Default to active

    @NotNull(message = "Employment type is required")
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    @NotEmpty(message = "Primary skills must not be empty")
    @ElementCollection
    @Column(name = "PRIMARY_SKILLS")
    private List<@NotBlank(message = "Primary skill cannot be blank") String> primarySkills;

    @ElementCollection
    @Column(name = "SECONDARY_SKILLS")
    private List<@NotBlank(message = "Secondary skill cannot be blank") String> secondarySkills;

    @Min(value = 0, message = "Work experience must be non-negative")
    @Column(name = "WORK_EXPERIENCE")
    private int workExperience;

    @Min(value = 1, message = "There must be at least one position")
    @Column(name = "NO_OF_POSITIONS")
    private int noOfPositions;

    @NotBlank(message = "Technology must not be empty")
    @Column(name = "TECHNOLOGY")
    private String technology;

    @NotBlank(message = "Job description must not be empty")
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;

    @Min(value = 0, message = "Relevant experience must be non-negative")
    @Column(name = "REL_EXP")
    private int relevantExperience;

    @NotBlank(message = "Domain must not be empty")
    @Column(name = "DOMAIN")
    private String domain;

    @NotBlank(message = "Pay rate must not be empty")
    @Column(name = "PAY_RATE")
    private String payRate;

    @NotBlank(message = "TA assignee must not be empty")
    @Column(name = "TA_ASSIGNEE")
    private String taAssignee;

    @NotBlank(message = "Location must not be empty")
    @Column(name = "LOCATION")
    private String location;

    @PastOrPresent(message = "Create date must be in the past or present")
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Future(message = "Target date must be in the future")
    @Column(name = "TARGET_DATE")
    private Date targetDate;

    @NotNull(message = "Work type is required")
    @Enumerated(EnumType.STRING)
    private WorkType workType;

    @NotBlank(message = "Languages required must not be empty")
    @Column(name = "LANGUAGES_REQUIRED")
    private String languagesRequired;

    @NotNull(message = "Priority is required")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotBlank(message = "Project ID must not be empty")
    @Column(name = "PROJECT_ID")
    private String projectId;

    @NotBlank(message = "Client job ID must not be empty")
    @Column(name = "CLIENT_JOB_ID")
    private String clientJobId;

    @Min(value = 0, message = "Number of submissions must be non-negative")
    @Column(name = "NO_OF_SUBMISSION")
    private int noOfSubmission;

    @NotBlank(message = "Vendor must not be empty")
    @Column(name = "VENDOR")
    private String vendor;

    @NotEmpty(message = "Account manager(s) must not be empty")
    @ElementCollection
    @Column(name = "ACCOUNT_MANAGER")
    private List<@NotBlank(message = "Account manager name cannot be blank") String> accountManager;
}
