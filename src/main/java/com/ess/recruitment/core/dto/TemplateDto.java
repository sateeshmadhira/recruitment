package com.ess.recruitment.core.dto;


import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.Qualification;
import com.ess.recruitment.core.utils.RemoteStatus;
import com.ess.recruitment.core.utils.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDto {
    private String templateId;
    private String title;
    private String primarySkills;
    private String secondarySkills;
    private String city;
    private Country country;
    private State state;
    private int workExperience;
    private int noOfPositions;
    private RemoteStatus remoteStatus;
    private String languagesRequired;
    private String jobDescription;
    private String approvalFlow;
    private Qualification qualification;
    private PayAndBillingDetailsDto payAndBillingDetailsDto;
}