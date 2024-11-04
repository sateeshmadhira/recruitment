package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.infrastructure.domain.sql.model.template.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<TemplateEntity,Long> {
}
