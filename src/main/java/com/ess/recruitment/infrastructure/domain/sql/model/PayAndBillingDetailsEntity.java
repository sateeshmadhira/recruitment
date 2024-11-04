package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.JobType;
import com.ess.recruitment.core.utils.PayType;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.template.TemplateEntity;
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
public class PayAndBillingDetailsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAY_ID")
    private Long payId;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

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

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private JobsEntity jobsEntity;
}
