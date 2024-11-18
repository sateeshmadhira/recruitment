package com.ess.recruitment.core.resp;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaginationResponse<T> implements Serializable {


    private int currentPage;
    private int totalPages;
    private long totalItems;
    private int pageSize;
    private List<T> content= new ArrayList<>();

}
