//package com.ess.recruitment.infrastructure.controller;
//import com.ess.recruitment.core.dto.JobsDTO;
//import com.ess.recruitment.core.dto.TemplateDTO;
//import com.ess.recruitment.infrastructure.domain.sql.service.impl.TemplateService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/template")
//@CrossOrigin("*")
//public class TemplateController {
//    @Autowired
//    TemplateService templateService;
//
//    @PostMapping
//    public ResponseEntity<TemplateDTO> createTemplate(@RequestBody TemplateDTO templateDTO){
//       TemplateDTO dto= templateService.createTemplate(templateDTO);
//        return ResponseEntity.ok(dto);
//    }
//    //@PostMapping
//   // public ResponseEntity<TemplateDTO> getAll(@RequestBody TemplateDTO templateDTO){
//   //     TemplateDTO dto=templateService.getAll(templateDTO);
//    //    return ResponseEntity.ok(dto);
//    }
//    @PostMapping
//   // public ResponseEntity<TemplateDTO> getById(@RequestBody TemplateDTO templateDTO){
//    //    TemplateDTO dto=templateService.getById(templateDTO);
//      //  return ResponseEntity.ok(dto);
//   // }
////}
