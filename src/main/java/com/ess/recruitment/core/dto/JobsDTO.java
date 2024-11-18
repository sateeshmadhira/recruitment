package com.ess.recruitment.core.dto;
import com.ess.recruitment.core.utils.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobsDTO {
    private Long jobId;
    private String jobCode;
    private Status status;
    private String jobTitle;
    private String technology;
    private int delFlag =1;
    private EmploymentType employmentType;
    private List<String>  primarySkills;
    private List<String> secondarySkills;
    private String jobDescription;
    private int relevantExperience;
    private String domain;
    private String payRate;
    private String taAssignee;
    private String location;
    private Date createDate;
    private int noOfSubmission;
    private String vendor;
    private int workExperience;
    private int noOfPositions;
    private Date targetDate;
    private WorkType workType;
    private String languagesRequired;
    private Priority priority;
    private String projectId;
    private String clientJobId;
    private List<String> accountManager;

}
