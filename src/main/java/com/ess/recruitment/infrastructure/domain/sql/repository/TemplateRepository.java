package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.core.dto.TemplateDTO;
import com.ess.recruitment.infrastructure.domain.sql.model.TemplateEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity,Long> {
  //  @Query("SELECT MAX(t.templateCode) FROM TemplateEntity t WHERE t.templateId = :templateId")
  //  Optional<String> findHighestTemplateCodeByTemplateId(@Param("templateId") Long templateId);



    @Query("SELECT t FROM TemplateEntity t " +
            "LEFT JOIN t.payAndBillingDetailsEntity p " +
            "WHERE " +
            "LOWER(t.title) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(t.primarySkills) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(t.secondarySkills) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(t.city) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(p.jobType) LIKE LOWER(CONCAT('%', :searchKeyword, '%'))")
    Page<TemplateEntity> searchTemplatesByKeyword(@Param("searchKeyword") String searchKeyword, Pageable pageable);


}
