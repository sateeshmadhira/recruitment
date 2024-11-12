package com.ess.recruitment.core.req;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class ReqFilter {
    private String id;
    private String code;
    private Integer pageSize;
    private Integer page;
    private Integer totalCount;
    private String sortBy;
    private Sort.Direction direction;
    private boolean loginUser;

    private  String searchKeyword;
}
