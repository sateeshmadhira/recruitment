package com.ess.recruitment.core.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PAYANDBILLINGDTO")
public class PayandBillingEntity {


    private String payType;
    private double payRateFrom;
    private double payRateTo;
    private boolean markAsPreferred;
}
