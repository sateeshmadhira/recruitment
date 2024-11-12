package com.ess.recruitment.infrastructure.domain.sql.model.template;

import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.Qualifications;
import com.ess.recruitment.core.utils.State;
import com.ess.recruitment.core.utils.WorkType;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


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

   // @NotNull(message = "Title is mandatory")
    @Column(name = "TITLE")
    private String title;

  //  @NotBlank(message = "Template code is mandatory")
    @Column(name = "TEMPLATE_CODE")
    private String templateCode;

    @ElementCollection
  //  @Size(min = 1, message = "At least one primary skill is required")
    @Column(name = "PRIMARY_SKILLS")
    private List<String> primarySkills = new ArrayList<>();

    @ElementCollection
    @Column(name = "SECONDARY_SKILLS")
    private List<String> secondarySkills = new ArrayList<>();

    @ElementCollection
    @Column(name = "TECHNICAL_SILLS")
    private List<String> technicalSkills = new ArrayList<>();

 //   @NotBlank(message = "City is mandatory")
    @Column(name = "CITY")
    private String city;

   // @NotNull(message = "Country is mandatory")
    @Enumerated(EnumType.STRING)
    private Country country;

  //  @NotNull(message = "State is mandatory")
    @Enumerated(EnumType.STRING)
    private State state;

   // @Min(value = 0, message = "Work experience must be zero or more")
    @Column(name = "WORK_EXPERIENCE")
    private int workExperience;

 //   @NotNull(message = "Work type is mandatory")
    @Enumerated(EnumType.STRING)
    private WorkType workType;

   // @NotBlank(message = "Languages required is mandatory")
    @Column(name = "LANGUAGES")
    private String languagesRequired;

  //  @NotBlank(message = "Job description is mandatory")
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;

    @Column(name = "APPROVAL_FLOW")
    private String approvalFlow;

   // @NotNull(message = "Qualifications are mandatory")
    @Enumerated(EnumType.STRING)
    private Qualifications qualifications;

   // @NotNull(message = "Status is mandatory")
    @Column(name = "STATUS")
    private Integer status;
}
