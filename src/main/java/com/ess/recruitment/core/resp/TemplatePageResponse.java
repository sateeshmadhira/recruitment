package com.ess.recruitment.core.resp;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data

public class TemplatePageResponse<T> {

    private  int pageSize;
    private  int currentPage;
    private String sortBy;
    private  int TotalPages;
    private  Long TotalElements;
    private List<T> data = new ArrayList<>();

}
