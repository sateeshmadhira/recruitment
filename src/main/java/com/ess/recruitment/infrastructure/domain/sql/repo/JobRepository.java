package com.ess.recruitment.infrastructure.domain.sql.repo;

import com.ess.recruitment.infrastructure.domain.sql.model.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobsEntity,Long> {
}
