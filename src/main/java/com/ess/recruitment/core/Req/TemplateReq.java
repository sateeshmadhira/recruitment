package com.ess.recruitment.core.req;


import com.ess.recruitment.core.dto.ResourcePoolDto;
import lombok.Data;


import java.io.Serializable;

@Data
public class TemplateReq extends ReqFilter implements Serializable {
     ResourcePoolDto resourcePoolDto=new ResourcePoolDto();
}
