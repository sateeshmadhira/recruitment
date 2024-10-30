package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.dto.PayAndBillingDetailsDTO;
import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.Qualifications;
import com.ess.recruitment.core.utils.RemoteStatus;
import com.ess.recruitment.core.utils.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class TemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATE_ID")
    private Long templateId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRIMARY_SKILLS")
    private String primarySkills;

    @Column(name = "SECONDARY_SKILLS")
    private String secondarySkills;

    @Column(name = "CITY")
    private String city;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "WORK_EXPERIENCE")
    private int workExperience;

    @Column(name = "NO_OF_POSITIONS")
    private int noOfPosition;

    @Enumerated(EnumType.STRING)
    private RemoteStatus remoteStatus;

    @Column(name = "LANGUAGES")
    private String languagesRequired;

    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;

    @Column(name = "APPROVAL_FLOW")
    private String approvalFlow;

    @Enumerated(EnumType.STRING)
    private Qualifications qualifications;

    @OneToOne(mappedBy = "templateEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private PayAndBillingDetailsEntity payAndBillingDetailsEntity;
}
