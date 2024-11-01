package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOBID")
    private String jobId;
    @Column(name = "STATUS")
    private Status status;
    @Column(name = "JOBTITLE")
    private String jobTitle;
    @Column(name="JOBTYPE")
    private JobType jobType;
    @Column(name="PRIMARYSKILLS")
    private String primarySkills;
    @Column(name="SECONDARYSKILLS")
    private String secondarySkills;
    @Enumerated(EnumType.STRING)
    private String city;
    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(name = "WORKEXPERIENCE")
    private int workExperience;
    @Column(name = "NOOFPOSITIONS")
    private int noOfPositions;
    @Column(name = "TARGATDATE")
    private Date targetDate;
    @Column(name = "REMOTESTATUS")
    private RemoteStatus remoteStatus;
    @Column(name = "LANGUAGESREQUIRED")
    private String languagesRequired;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private PayAndBillingEntity payAndBillingEntity;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private RecruitmentTeamEntity recruitmentTeamEntity;

    @OneToOne(mappedBy = "jobsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private JobDescriptionEntity jobDescriptionEntity;

}
