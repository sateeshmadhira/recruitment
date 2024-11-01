package com.ess.recruitment.core.Req;

import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class TemplateReq {

    TemplateDTO templateDTO = new TemplateDTO();

    private String id;
    private String code;
    private Integer pageSize;
    private Integer page;
    private Integer totalCount;
    private String sortBy;
    private Sort.Direction direction;
    private  String searchKeyword;


}
