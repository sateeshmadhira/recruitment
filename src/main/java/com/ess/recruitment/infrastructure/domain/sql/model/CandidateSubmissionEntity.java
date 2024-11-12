package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.PayType;
import com.ess.recruitment.core.utils.State;
import com.ess.recruitment.core.utils.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CANDIDATE_SUBMISSION")
public class CandidateSubmissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "IS_ACTIVE")
    private Integer delFlag = 1;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name ="CANDIDATE_CODE")
    private String candidateCode;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name ="CITY")
    private String city;

    @Column(name = "ZIP")
    private String zip;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "CURRENT_LOCATION")
    private String currentLocation;

    @Column(name = "TOTAL_EXPERIENCE")
    private String totalExperience;

    @Column(name = "RELEVANT_EXPERIENCE")
    private String relevantExperience;

    @Column(name = "NOTICE_PERIOD")
    private String noticePeriod;

    @Column(name = "CURRENT_ORGANIZATION")
    private String currentOrganization;

    @Column(name = "EXPECTED_CTC")
    private String expectedCtc;

    @Column(name = "RATE")
    private String rate;

    @Enumerated(EnumType.STRING)
    private PayType ctcType; // Hourly/Monthly/Yearly

    @Column(name = "LINKED_IN_URL")
    private String linkedInUrl;

    @Column(name = "ALTERNATE_CONTACT_NUMBER")
    private String alternateContactNumber;

    @Column(name = "WORK_AUTHORIZATION")
    private String workAuthorization;

    @Column(name = "WILLING_TO_RELOCATION")
    private Boolean willingToRelocate;

    @Column(name = "WORKED_WITH_CLIENT")
    private Boolean workedWithClient;

    @Column(name = "CLIENT_DETAILS")
    private String clientDetails; // Only populated if workedWithClient is true

    @Column(name = "COMMUNICATION_SKILLS")
    private Integer communicationSkills; // Rating from 1 to 5

    @Column(name="DEGREE")
    private String degree;

    @Column(name="UNIVERSITY")
    private String university;

    @Column(name = "YEAR_OF_PASSED")
    @Temporal(TemporalType.DATE)
    private Date yearOfPassed;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Column()
    private Boolean consent;

    @Column(name = "RESUME_FILE")
    private String resumeFile; // URL or identifier for the resume file

    @Column(name = "ID_PROOF_FILE")
    private String idProofFile; // URL or identifier for the ID proof
}
