package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.spi.ManagedEntity;

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


    @NotNull(message = "INTERVIEW_CODE IS MANDATORY")
    @Column(name = "INTERVIEW_CODE")
    private String interviewCode;

    @Column(name = "IS_ACTIVE")
    private Integer delFlag = 1;

    @NotNull(message = "INTERVIEW_TIME IS MANDATORY")
    @Column(name = "INTERVIEW_TIME")
    private LocalDate interviewTime;

    @NotNull(message = "TIME_ZONE IS MANDATORY")
    @Column(name = "TIME_ZONE")
    private LocalDate timeZone;

    @NotNull(message = "INTERVIEW_TYPE IS MANDATORY")
    @Column(name = "INTERVIEW_TYPE")
    private String interviewType;

    @NotNull(message = "STATUS IS MANDATORY")
    @Column(name = "STATUS")
    private Status status;

    @NotNull(message = "STAGE IS MANDATORY")
    @Column(name = "STAGE")
    private String stage;

    @NotNull(message = "LOCATION IS MANDATORY")
    @Column(name = "LOCATION")
    private String location;

    @NotNull(message = "DESCRIPTION IS MANDATORY")
    @Column(name = "DESCRIPTION")
    private String description;

    // private byte[] attachment;
    @NotNull(message = "TAG_DETAILS IS MANDATORY")
    @Column(name = "TAG_DETAILS")
    private String tagDetails;

    @NotNull(message = "SELECT_FEEDBACK_TEMPLATE IS MANDATORY")
    @Column(name = "SELECT_FEEDBACK_TEMPLATE")
    private String selectFeedbackTemplate;

    @NotNull(message = "INTERVIEWER IS MANDATORY")
    @Column(name = "INTERVIEWER")
    private String interviewer;

    @NotNull(message = "ATTACHMENTS IS MANDATORY")
    @Column(name = "ATTACHMENTS")
    private String attachments;

    @NotNull(message = "EMAIL_TYPE IS MANDATORY")
    @Column(name = "EMAIL_TYPE")
    private String emailType;

    @NotNull(message = "JOB_DESCRIPTION IS MANDATORY")
    @Column(name = "JOB_DESCRIPTION")
    private boolean jobDescription;

    @NotNull(message = "CONTACT_DETAILS IS MANDATORY")
    @Column(name = "CONTACT_DETAILS")
    private boolean contactDetails;

    @NotNull(message = "PREVIOUS_INTERVIEWS_FEEDBACK IS MANDATORY")
    @Column(name = "PREVIOUS_INTERVIEWS_FEEDBACK")
    private boolean previousInterviewsFeedback;

}