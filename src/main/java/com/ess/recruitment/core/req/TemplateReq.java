package com.ess.recruitment.core.req;


import com.ess.recruitment.core.dto.template.TemplateDTO;
import lombok.Data;


import java.io.Serializable;

@Data
public class TemplateReq extends ReqFilter implements Serializable {

    TemplateDTO templateDTO = new TemplateDTO();


}
