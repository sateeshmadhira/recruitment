package com.ess.recruitment.infrastructure.domain.sql.model.template;

import com.ess.recruitment.core.utils.EmploymentType;
import com.ess.recruitment.core.utils.PayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class PayAndBillingDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAY_ID")
    private Long payId;

    @Enumerated(EnumType.STRING)
    private EmploymentType jobType;

    @Enumerated(EnumType.STRING)
    private PayType payType;

    @Column(name = "PAY_RATE")
    private int payRate;

    @Column(name = "CONTRACT_TYPE")
    private String contractType;

    @Column(name = "CONTRACT_PERIOD")
    private int contractPeriod;

    @Column(name = "MARK_AS_PREFERRED")
    private boolean markAsPreferred;

    @OneToOne
    @JoinColumn(name = "TEMPLATE_ID")
    private TemplateEntity templateEntity;
    
}
