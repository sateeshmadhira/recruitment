package com.ess.recruitment.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentTeamDTO {

    private List<String>  recruiters;
    private List<String>  additionalRecruiters;
    private List<String> recruitmentManager;
    private List<String> source;
    private List<String> interviewPanel;
    private int maxSubmissions;
    private List<String> accountManager;
    private Long jobId;


}
