package com.ess.recruitment.core.utils;

import com.ess.recruitment.core.constants.TemplateConstants;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.TemplatePageResponse;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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


public static ApiResponse apiResponseSuccess(String message, TemplatePageResponse data, HttpStatus status) {
    ApiResponse apiResponse = new ApiResponse(TemplateConstants.SUCCESS, status.value(),message, data);
    return apiResponse;
}

public static ApiResponse apiResponseError(String message, TemplatePageResponse data, HttpStatus status) {
    ApiResponse apiResponse = new ApiResponse(TemplateConstants.ERROR,  status.value(), message,data);
    return apiResponse;
}

}
