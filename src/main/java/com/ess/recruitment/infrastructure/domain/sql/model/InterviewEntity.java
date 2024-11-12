package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class InterviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTERVIEW_ID")
    private Long interviewId;

    @Column(name = "INTERVIEW_CODE")
    private String interviewCode;

    @Column(name = "IS_ACTIVE")
    private Integer delFlag = 1;

    @Column(name = "INTERVIEW_TIME")
    private LocalDate interviewTime;

    @Column(name = "TIME_ZONE")
    private LocalDate timeZone;

    @Column(name = "INTERVIEW_TYPE")
    private String interviewType;

    @Column(name = "STATUS")
    private Status status;

    @Column(name = "STAGE")
    private String stage;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "DESCRIPTION")
    private String description;

    // private byte[] attachment;

    @Column(name = "TAG_DETAILS")
    private String tagDetails;

    @Column(name = "SELECT_FEEDBACK_TEMPLATE")
    private String selectFeedbackTemplate;

    @Column(name = "INTERVIEWER")
    private String interviewer;

    @Column(name = "ATTACHMENTS")
    private String attachments;

    @Column(name = "EMAIL_TYPE")
    private String emailType;

    @Column(name = "JOB_DESCRIPTION")
    private boolean jobDescription;

    @Column(name = "CONTACT_DETAILS")
    private boolean contactDetails;

    @Column(name = "PREVIOUS_INTERVIEWS_FEEDBACK")
    private boolean previousInterviewsFeedback;

}