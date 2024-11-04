package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobsEntity,Long> {


    // Get the latest Job by ID in descending order
    Optional<JobsEntity> findTopByOrderByJobCodeDesc();

}
