package com.ess.recruitment.infrastructure.domain.sql.model.template;

import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.Qualifications;
import com.ess.recruitment.core.utils.WorkType;
import com.ess.recruitment.core.utils.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class TemplateEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATE_ID")
    private Long templateId;

    @Column(name = "TITLE")
    private String title;

    @Column(name="TEMPLATE_CODE")
    private String templateCode;

    @ElementCollection
    @Column(name = "PRIMARY_SKILLS")
    private List<String> primarySkills =new ArrayList<>();

    @ElementCollection
    @Column(name = "SECONDARY_SKILLS")
    private List<String> secondarySkills =new ArrayList<>();

    @ElementCollection
    @Column(name = "TECHNICAL_SILLS")
    private  List<String> technicalSkills =new ArrayList<>();

    @Column(name = "CITY")
    private String city;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "WORK_EXPERIENCE")
    private int workExperience;

    @Enumerated(EnumType.STRING)
    private WorkType workType;

    @Column(name = "LANGUAGES")
    private String languagesRequired;

    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;

    @Column(name = "APPROVAL_FLOW")
    private String approvalFlow;

    @Enumerated(EnumType.STRING)
    private Qualifications qualifications;

    @Column(name = "STATUS")
    private  Integer status;


}
