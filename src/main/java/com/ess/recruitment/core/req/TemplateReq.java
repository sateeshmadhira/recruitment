package com.ess.recruitment.core.req;


import com.ess.recruitment.core.dto.ResourcePoolDto;
import lombok.Data;
import org.springframework.data.domain.Sort;


import java.io.Serializable;

@Data
public class TemplateReq extends ReqFilter implements Serializable {
     ResourcePoolDto resourcePoolDto=new ResourcePoolDto();
//     TemplateDTO templateDTO = new TemplateDTO();

}

