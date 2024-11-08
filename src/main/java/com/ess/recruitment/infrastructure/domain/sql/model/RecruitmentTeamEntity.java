package com.ess.recruitment.infrastructure.domain.sql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class RecruitmentTeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_RECRU_ID")
    private Long id;

    @ElementCollection
    @Column(name = "RECRUITERS")
    private List<String> recruiters;

    @ElementCollection
    @Column(name = "ADD_RECRUITERS")
    private List<String>  additionalRecruiters;

    @ElementCollection
    @Column(name = "RECRUITMENT_MANAGER")
    private List<String> recruitmentManager;

    @ElementCollection
    @Column(name = "SOURCE")
    private List<String> source;

    @ElementCollection
    @Column(name = "INTERVIEW_PANEL")
    private List<String> interviewPanel;

    @Column(name = "MAX_SUBMISSIONS")
    private int maxSubmissions;

    @ElementCollection
    @Column(name = "ACCOUNT_MANAGER")
    private List<String> accountManager;

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private JobsEntity jobsEntity;
}
