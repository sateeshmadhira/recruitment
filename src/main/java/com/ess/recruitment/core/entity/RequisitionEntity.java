package com.ess.recruitment.core.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Requisition")
public class RequisitionEntity {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Requisition_ID",nullable = false)
    private Long requisitionId;

    @Column(name = "Requisition_TITLE")
    private String title;
    @Column(name = "Requisition_STATUS")
    private String status;
    @Column(name = "Requisition_APPROVALFLOW")
    private String approvalFlow;
    @Column(name = "Requisition_QUALIFICATION")
    private String qualifications;
}
