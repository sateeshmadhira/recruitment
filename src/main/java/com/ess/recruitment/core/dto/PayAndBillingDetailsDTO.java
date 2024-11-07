package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.EmploymentType;
import com.ess.recruitment.core.utils.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayAndBillingDetailsDTO {
    private Long payId;
    private EmploymentType jobType;
    private PayType payType;
    private int payRate;
    private String contractType;
    private int contractPeriod;
    private boolean markAsPreferred;
    private Long templateId;
    private Long jobId;
}
