package com.ess.recruitment.core.dto.template;

import com.ess.recruitment.core.dto.PayAndBillingDetailsDTO;
import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.Qualifications;
import com.ess.recruitment.core.utils.WorkType;
import com.ess.recruitment.core.utils.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDTO {

    private Long templateId;
    private String title;
    private String primarySkills;
    private String secondarySkills;
    private String city;
    private Country country;
    private State state;
    private int workExperience;
    private int noOfPosition;
    private WorkType remoteStatus;
    private String languagesRequired;
    private String jobDescription;
    private String approvalFlow;
    private Qualifications qualifications;
    private PayAndBillingDetailsDTO payAndBillingDetailsDTO;
}
