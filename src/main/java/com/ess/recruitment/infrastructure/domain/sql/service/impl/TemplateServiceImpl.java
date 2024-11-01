package com.ess.recruitment.infrastructure.domain.sql.service.impl;

import com.ess.recruitment.core.Req.TemplateReq;
import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.core.resp.ApiResponse;
import com.ess.recruitment.core.resp.TemplatePageResponse;
import com.ess.recruitment.core.utils.AppUtils;
import com.ess.recruitment.infrastructure.domain.sql.model.PayAndBillingDetailsEntity;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import com.ess.recruitment.infrastructure.domain.sql.repository.TemplateRepository;
import com.ess.recruitment.infrastructure.domain.sql.service.handler.MapperConfig;
import com.ess.recruitment.infrastructure.domain.sql.service.impl.TemplateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    TemplateRepository templateRepository;
    @Autowired
    MapperConfig mapperConfig;


    @Override
    public ApiResponse createTemplate(TemplateReq  templateReq) {

        try{
//                String projectCodePrefix = "TEMP-";
//                String newTemplateCode;
                if (templateReq.getTemplateDTO()== null) {
                    return AppUtils.apiResponseSuccess(
                            "unable to Create Project please provide SubscriptionId",null, HttpStatus.NOT_FOUND);
                }
//                // Retrieve the highest projectCode for the given Customer
//                Optional<String> highestProjectCodeOpt = templateRepository.findHighestCustomerCodeByCustomerId(templateReq.getTemplateDTO().getTemplateId());
//                int highestCodeNumber = 0;
//                if (highestProjectCodeOpt.isPresent()) {
//                    String highestCustomerCode = highestProjectCodeOpt.get();
//                    highestCodeNumber = Integer.parseInt(highestCustomerCode.substring(projectCodePrefix.length()));
//                }
//            newTemplateCode = projectCodePrefix + String.format("%03d", highestCodeNumber + 1);

                TemplateEntity templateEntity = mapperConfig.toEntity(templateReq.getTemplateDTO());
                TemplateEntity saveTemplateEntity = templateRepository.save(templateEntity);
                TemplateDTO saveDto = mapperConfig.toDto(saveTemplateEntity);

                TemplatePageResponse templatePageResponse = new TemplatePageResponse();
                templatePageResponse.setData(List.of(saveDto));
                return AppUtils.apiResponseSuccess("Template Saved Suceessfull",templatePageResponse,HttpStatus.OK) ;
        }catch (Exception e){
            return AppUtils.apiResponseError(e.getMessage(),null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Transactional
    @Override
    public ApiResponse getTemplatetById(Long id){
        try {
            Optional<TemplateEntity> templateEntity = templateRepository.findById(id);
            TemplateDTO templateDTO;

            if (!templateEntity.isEmpty()) {
                templateDTO = mapperConfig.toDto(templateEntity.get());

                TemplatePageResponse templatePageResponse = new TemplatePageResponse();
                templatePageResponse.setData(List.of(templateDTO));

             return    AppUtils.apiResponseSuccess("Templates Retrieve Successfully",templatePageResponse, HttpStatus.OK);


            } else {
                return AppUtils.apiResponseSuccess(" No Templates Found ,",null,HttpStatus.OK);
            }
        }
        catch (Exception e){
            return  AppUtils.apiResponseError(e.getMessage(), null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @Override
    public ApiResponse getAllTemplates(TemplateReq templateReq){
        try{
        List<TemplateEntity> templateEntity = templateRepository.findAll();
            Pageable pageable = PageRequest.of(
                    templateReq.getPage(),
                    templateReq.getPageSize(),
                    Sort.by(templateReq.getDirection(), templateReq.getSortBy())
            );
            Page<TemplateEntity> results = templateRepository.searchTemplatesByKeyword(templateReq.getSearchKeyword(), pageable);

            List<TemplateDTO> templateDTOList = new ArrayList<>();
        if(!templateEntity.isEmpty()){
            templateEntity.stream().map(templateEntity1 -> {
              TemplateDTO templateDTO =  mapperConfig.toDto(templateEntity1);
              templateDTOList.add(templateDTO);
              return  templateDTOList;
            }).toList();

            TemplatePageResponse templatePageResponse = new TemplatePageResponse();
            templatePageResponse.setData(templateDTOList);
            return  AppUtils.apiResponseSuccess("",templatePageResponse,HttpStatus.OK);
        }else {
            return  AppUtils.apiResponseError("",null,HttpStatus.NOT_FOUND);
        }
        }catch (Exception e){
            System.out.println("error message : "+e.getMessage());
            return  AppUtils.apiResponseError("Error : "+e.getMessage(), null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ApiResponse updateTemplate(Long id, TemplateReq templateReq) {
        try {
            Optional<TemplateEntity> existingEntityOpt = templateRepository.findById(id);

            if (existingEntityOpt.isPresent()) {
                TemplateEntity existingEntity = existingEntityOpt.get();
                TemplateEntity updateEntity = mapperConfig.toEntity(templateReq.getTemplateDTO());

                // Update fields only if they are provided in the update request
                if (updateEntity.getTitle() != null) {
                    existingEntity.setTitle(updateEntity.getTitle());
                }
                if (updateEntity.getPrimarySkills() != null) {
                    existingEntity.setPrimarySkills(updateEntity.getPrimarySkills());
                }
                if (updateEntity.getSecondarySkills() != null) {
                    existingEntity.setSecondarySkills(updateEntity.getSecondarySkills());
                }
                if (updateEntity.getCity() != null) {
                    existingEntity.setCity(updateEntity.getCity());
                }
                if (updateEntity.getState() != null) {
                    existingEntity.setState(updateEntity.getState());
                }
                if (updateEntity.getCountry() != null) {
                    existingEntity.setCountry(updateEntity.getCountry());
                }
                if (updateEntity.getWorkExperience() != 0) {
                    existingEntity.setWorkExperience(updateEntity.getWorkExperience());
                }
                if (updateEntity.getNoOfPosition() != 0) {
                    existingEntity.setNoOfPosition(updateEntity.getNoOfPosition());
                }
                if (updateEntity.getRemoteStatus() != null) {
                    existingEntity.setRemoteStatus(updateEntity.getRemoteStatus());
                }
                if (updateEntity.getLanguagesRequired() != null) {
                    existingEntity.setLanguagesRequired(updateEntity.getLanguagesRequired());
                }
                if (updateEntity.getJobDescription() != null) {
                    existingEntity.setJobDescription(updateEntity.getJobDescription());
                }
                if (updateEntity.getApprovalFlow() != null) {
                    existingEntity.setApprovalFlow(updateEntity.getApprovalFlow());
                }
                if (updateEntity.getQualifications() != null) {
                    existingEntity.setQualifications(updateEntity.getQualifications());
                }

                // Update PayAndBillingDetailsEntity if it exists or needs to be added
                if (updateEntity.getPayAndBillingDetailsEntity() != null) {
                    PayAndBillingDetailsEntity updatePayDetails = updateEntity.getPayAndBillingDetailsEntity();
                    PayAndBillingDetailsEntity existingPayDetails = existingEntity.getPayAndBillingDetailsEntity();

                    if (existingPayDetails != null) {
                        if (updatePayDetails.getJobType() != null) {
                            existingPayDetails.setJobType(updatePayDetails.getJobType());
                        }
                        if (updatePayDetails.getPayType() != null) {
                            existingPayDetails.setPayType(updatePayDetails.getPayType());
                        }
                        if (updatePayDetails.getPayRate() != 0) {
                            existingPayDetails.setPayRate(updatePayDetails.getPayRate());
                        }
                        if (updatePayDetails.getContractType() != null) {
                            existingPayDetails.setContractType(updatePayDetails.getContractType());
                        }
                        if (updatePayDetails.getContractPeriod() != 0) {
                            existingPayDetails.setContractPeriod(updatePayDetails.getContractPeriod());
                        }
                        existingPayDetails.setMarkAsPreferred(updatePayDetails.isMarkAsPreferred());
                    } else {
                        // If there is no existing PayAndBillingDetailsEntity, add it as new
                        updatePayDetails.setTemplateEntity(existingEntity);
                        existingEntity.setPayAndBillingDetailsEntity(updatePayDetails);
                    }
                }

                // Save and return the updated entity
                TemplateEntity updatedEntity = templateRepository.save(existingEntity);
                TemplateDTO updatedDto = mapperConfig.toDto(updatedEntity);
                TemplatePageResponse<TemplateDTO> templatePageResponse = new TemplatePageResponse<>();
                templatePageResponse.setData(List.of(updatedDto));

                return AppUtils.apiResponseSuccess("Updated successfully", templatePageResponse, HttpStatus.OK);
            } else {
                return AppUtils.apiResponseError("Template not found", null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return AppUtils.apiResponseError("Error: " + e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
