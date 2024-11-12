package com.ess.recruitment.infrastructure.domain.sql.repository;


import com.ess.recruitment.infrastructure.domain.sql.model.template.TemplateEntity;
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

    @Query("SELECT MAX(t.templateCode) FROM #{#entityName} t")
    Optional<String> findLatestCode();
Long countByStatus(int status);


    Page<TemplateEntity> findByStatus(int status,Pageable pageable);


    @Query("SELECT t FROM TemplateEntity t " +
            "WHERE (:searchKeyword IS NULL OR " +
            "LOWER(t.title) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(t.templateCode) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(t.city) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(t.languagesRequired) LIKE LOWER(CONCAT('%', :searchKeyword, '%')) " +
            "OR LOWER(t.jobDescription) LIKE LOWER(CONCAT('%', :searchKeyword, '%'))) ")
    Page<TemplateEntity> searchTemplatesByKeyword(String searchKeyword, Pageable pageable);


}
