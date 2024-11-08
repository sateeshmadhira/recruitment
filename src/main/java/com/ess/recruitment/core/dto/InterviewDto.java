package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewDto {
    private Long interviewId;
    private String interviewCode;
    private LocalDate interviewTime;
    private LocalDate timeZone;
    private String interviewType;
    private Status status;
    private String stage;
    private String location;
    private String description;
   // private byte[] attachment;
    private String tagDetails;
    private String selectFeedbackTemplate;
    private String interviewer;
    private String attachments;
    private String emailType;
    private boolean jobDescription;
    private boolean contactDetails;
    private boolean previousInterviewsFeedback;

}
