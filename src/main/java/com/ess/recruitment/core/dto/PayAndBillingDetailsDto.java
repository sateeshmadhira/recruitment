package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.JobType;
import com.ess.recruitment.core.utils.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayAndBillingDetailsDto {
    private Long payId;
    private PayType payType;
    private JobType jobType;
    private int payRate;
    private String contractType;
    private int contractPeriod;
    private boolean markAsPreferred;
    private Long templateId;
    private Long jobId;
}
