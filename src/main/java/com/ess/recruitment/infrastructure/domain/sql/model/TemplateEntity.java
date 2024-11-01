package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.Qualification;
import com.ess.recruitment.core.utils.RemoteStatus;
import com.ess.recruitment.core.utils.State;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateEntity {
    @Id
    private Long templateId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRIMARYSKILLS")
    private String primarySkills;

    @Column(name="SECONDARYSKILLS")
    private String secondarySkills;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private Country country;

    @Column(name="STATE")
    private State state;

    @Column(name="WORKEXPERIENCE")
    private int workExperience;

    @Column(name="NOOFPOSITIONS")
    private int noOfPositions;

    @Enumerated(EnumType.STRING)
    private RemoteStatus remoteStatus;

    @Column(name = "LANGUAGEs")
    private String languagesRequired;

    @Column(name = "JOBDESCRIPTION")
    private String jobDescription;

    @Column(name = "APPROVALFLOW")
    private String approvalFlow;

    @Enumerated(EnumType.STRING)
    private Qualification qualification;

    @OneToOne(mappedBy = "templateEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private PayAndBillingEntity payAndBillingDetailsEntity;
}
