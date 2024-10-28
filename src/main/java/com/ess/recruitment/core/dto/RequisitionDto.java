package com.ess.recruitment.core.dto;


import lombok.Data;

@Data
public class RequisitionDto {

    private Long requisitionId;
    private String title;
    private String status;
    private String approvalFlow;
    private String qualifications;
}
