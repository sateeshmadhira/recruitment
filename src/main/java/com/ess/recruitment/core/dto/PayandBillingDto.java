package com.ess.recruitment.core.dto;


import lombok.Data;

@Data
public class PayandBillingDto {
    private String payType;
    private double payRateFrom;
    private double payRateTo;
    private boolean markAsPreferred;
}
