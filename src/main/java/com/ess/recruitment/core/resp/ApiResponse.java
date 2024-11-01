package com.ess.recruitment.core.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private  String message;
    private  int code;
    private  String  status;
    private TemplatePageResponse templatePageResponse;

}
