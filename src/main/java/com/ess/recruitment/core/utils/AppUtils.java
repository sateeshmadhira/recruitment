package com.ess.recruitment.core.utils;

import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.TemplatePageResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;

import java.util.Optional;


public class AppUtils<T> {



public  static <T> TemplatePageResponse <T> templaytePageResponseMethod(Page<T> pageEntity){
    PageImpl<T> page = (PageImpl<T>) pageEntity ;
    TemplatePageResponse projectPageResponse=new TemplatePageResponse();
        projectPageResponse.setTotalPages(page.getTotalPages());
        projectPageResponse.setTotalElements(page.getTotalElements());
        projectPageResponse.setSortBy(page.getSort().toString());
        projectPageResponse.setCurrentPage(page.getNumber());
        projectPageResponse.setPageSize(page.getSize());

        return projectPageResponse;
}
    public static String generateNextCode(Optional<String> latestCode, String prefix, int codeLength) {
        return latestCode
                .map(code -> {
                    String numericPart = code.substring(prefix.length());
                    int nextCodeNumber = Integer.parseInt(numericPart) + 1;
                    return prefix + String.format("%0" + codeLength + "d", nextCodeNumber);
                })
                .orElse(prefix + String.format("%0" + codeLength + "d", 1));
    }


public static ApiResponse apiResponseSuccess(String message, TemplatePageResponse data, HttpStatus status) {
    ApiResponse apiResponse = new ApiResponse( message,data, status );
    return apiResponse;
}

public static ApiResponse apiResponseError(String message, TemplatePageResponse data, HttpStatus status) {
    ApiResponse apiResponse = new ApiResponse( message ,data,status);
    return apiResponse;
}

}
