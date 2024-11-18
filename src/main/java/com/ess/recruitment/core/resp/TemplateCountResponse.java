package com.ess.recruitment.core.resp;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Data
@Getter
@Setter
public class TemplateCountResponse {
    private Long activeCount;
    private Long inactiveCount;
    private Long totalCount;
}
