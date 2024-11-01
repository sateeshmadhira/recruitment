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
public class InterivewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTERIVEW_ID")
    private long interivewId;

    @Column(name = "INTERIVEW_TIME")
    private LocalDate interivewTime;

    @Column(name = "TIME_ZONE")
    private LocalDate timeZone;

    @Column(name = "INTERIVEW_TYPE")
    private String interivewtype;

    @Column(name = "STATUS")
    private Status status;

    @Column(name = "STAGE")
    private String stage;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "DESCRPTION")
    private String descrption;

    // private byte[] attachment;

    @Column(name = "TAG_DETAILS")
    private String tagDetails;

    @Column(name = "SELECT_FEEDBACK_TEMPLATE")
    private String selectFeedbackTemplate;

    @Column(name = "INTERVIWER")
    private String interviewer;

  //  @Column(name = "ATTACHMENTS")
  //  private String attachments;

    @Column(name = "EMAIL_TYPE")
    private String emailType;

    @Column(name = "JOB_DESCRIPTION")
    private boolean jobDescription;

    @Column(name = "CONTACT_DETAILS")
    private boolean contactDetails;

    @Column(name = "PERIVIOUS_INTERVIEWS_FEEDBACK")
    private boolean periviousInterviewsFeedback;

}