package com.ess.recruitment.core.resp;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;
    private PaginationResponse paginationResponse;
    private TemplatePageResponse templatePageResponse;
    private long count;
    private HttpStatus status;

    public ApiResponse(boolean success, String message, long count, Object data) {
        this.success = success;
        this.message = message;
        this.count = count;
        this.data = data;
    }

    public ApiResponse(boolean success, String message, Object data, PaginationResponse paginationResponse, long count) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.paginationResponse = paginationResponse;
        this.count = count;
    }
    public ApiResponse() {
    }

    public ApiResponse( String message,TemplatePageResponse templatePageResponse,HttpStatus status) {

        this.message = message;
        this.templatePageResponse = templatePageResponse;
        this.status = status;

    }
}

