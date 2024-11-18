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

    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(boolean success, String message,PaginationResponse paginationResponse) {
        this.success = success;
        this.message = message;
        this.paginationResponse = paginationResponse;
    }

    public ApiResponse(boolean success, String message, Object data, PaginationResponse paginationResponse) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.paginationResponse = paginationResponse;
    }
    public ApiResponse( String message,TemplatePageResponse templatePageResponse,HttpStatus status) {

        this.message = message;
        this.templatePageResponse = templatePageResponse;
        this.status = status;

    }
}