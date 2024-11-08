package com.ess.recruitment.core.dto.template;

import com.ess.recruitment.core.utils.Country;
import com.ess.recruitment.core.utils.Qualifications;
import com.ess.recruitment.core.utils.WorkType;
import com.ess.recruitment.core.utils.State;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDTO implements Serializable {

    private Long templateId;
    private String title;
    private  int status;
    private String templateCode;
    private List<String> primarySkills=new ArrayList<>();
    private List<String> secondarySkills=new ArrayList<>();
    private  List<String> technicalSkills=new ArrayList<>();
    private String city;
    private Country country;
    private State state;
    private int workExperience;
    private WorkType workType;
    private String languagesRequired;
    private String jobDescription;
    private String approvalFlow;
    private Qualifications qualifications;

}
