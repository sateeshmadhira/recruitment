package com.ess.recruitment.core.resp;

import lombok.Data;

@Data
public class TemplateCountResponse {
    private Long activeCount;
    private Long inactiveCount;
    private Long totalCount;
}
