package com.ess.recruitment.core.req;//package com.ess.recruitment.core.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchReq {
    private String searchKey;
    private int page;
    private int pageSize;
}
