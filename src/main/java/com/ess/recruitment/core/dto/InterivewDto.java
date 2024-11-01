package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterivewDto {
    private LocalDate interivewTime;
    private LocalDate timeZone;
    private String interivewtype;
    private Status status;
    private String stage;
    private String location;
    private String descrption;
   // private byte[] attachment;
    private String tagDetails;
    private String selectFeedbackTemplate;
    private String interviewer;
    private String attachments;
    private String emailType;
    private boolean jobDescription;
    private boolean contactDetails;
    private boolean periviousInterviewsFeedback;

}
