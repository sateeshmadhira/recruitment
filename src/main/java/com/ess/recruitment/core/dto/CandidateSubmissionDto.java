package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.PayType;
import com.ess.recruitment.core.utils.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSubmissionDto {
    private Long id;
    private String candidateCode;
    private String jobId;
    private int delFlag =1;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;
    private String city;
    private String zip;
    private State state;
    private String currentLocation;
    private String totalExperience;
    private String relevantExperience;
    private String noticePeriod;
    private String currentOrganization;
    private String expectedCtc;
    private String rate;
    private PayType ctcType; // Hourly/Monthly/Yearly
    private String linkedInUrl;
    private String alternateContactNumber;
    private String workAuthorization;
    private Boolean willingToRelocate;
    private Boolean workedWithClient;
    private String clientDetails; // Textbox if worked with client is Yes
    private Integer communicationSkills; // Rating 1 to 5
    private String degree;
    private String university;
    private Date yearOfPassed;
    private Country country;
    private Boolean consent;
    private String resumeFile; // URL or identifier for the resume file
    private String idProofFile;// URL or identifier for the ID proof
}
