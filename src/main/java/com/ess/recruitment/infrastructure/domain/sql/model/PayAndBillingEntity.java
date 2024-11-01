package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.JobType;
import com.ess.recruitment.core.utils.PayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayAndBillingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAYID")
    private Long payId;
    @Column(name = "PAYTYPE")
    private PayType payType;
    @Column(name = "JOBTYPE")
    private JobType jobType;
    @Column(name = "PAYRATE")
    private int payRate;
    @Column(name = "CONTRACTTYPE")
    private String contractType;
    @Column(name = "CONTRACTPERIOD")
    private int contractPeriod;
    @Column(name = "MARKASPREFERRED")
    private boolean markAsPreferred;

    @OneToOne
    @JoinColumn(name = "TEMPLATE_ID")
    private TemplateEntity templateEntity;

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private JobsEntity jobsEntity;
}
