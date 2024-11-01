package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.Industry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class JobDescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Industry jobDomain;

    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;

    @Column(name = "RECRUITER_INSTRUCTIONS")
    private String recruiterInstructions;

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private JobsEntity jobsEntity;
    //private byte[] attachments;
}