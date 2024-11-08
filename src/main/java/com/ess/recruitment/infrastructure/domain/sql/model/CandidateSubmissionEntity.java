package com.ess.recruitment.infrastructure.domain.sql.model;

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

    @Column(name = "job_id", nullable = false)
    private String jobId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    private String address;
    private String city;
    private String zip;
    private String state;

    @Column(name = "current_location")
    private String currentLocation;

    @Column(name = "total_experience")
    private String totalExperience;

    @Column(name = "relevant_experience")
    private String relevantExperience;

    @Column(name = "notice_period")
    private String noticePeriod;

    @Column(name = "current_organization")
    private String currentOrganization;

    @Column(name = "expected_ctc")
    private String expectedCtc;

    private String rate;

    @Column(name = "ctc_type")
    private String ctcType; // Hourly/Monthly/Yearly

    @Column(name = "linkedin_url")
    private String linkedInUrl;

    @Column(name = "alternate_contact_number")
    private String alternateContactNumber;

    @Column(name = "work_authorization")
    private String workAuthorization;

    @Column(name = "willing_to_relocate")
    private Boolean willingToRelocate;

    @Column(name = "worked_with_client")
    private Boolean workedWithClient;

    @Column(name = "client_details")
    private String clientDetails; // Only populated if workedWithClient is true

    @Column(name = "communication_skills")
    private Integer communicationSkills; // Rating from 1 to 5

    private String degree;
    private String university;

    @Column(name = "year_of_passed")
    @Temporal(TemporalType.DATE)
    private Date yearOfPassed;

    private String country;

    @Column(nullable = false)
    private Boolean consent;

    @Column(name = "resume_file")
    private String resumeFile; // URL or identifier for the resume file

    @Column(name = "id_proof_file")
    private String idProofFile; // URL or identifier for the ID proof
}
