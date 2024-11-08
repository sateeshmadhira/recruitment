package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.infrastructure.domain.sql.model.InterviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<InterviewEntity,Long> {


}
