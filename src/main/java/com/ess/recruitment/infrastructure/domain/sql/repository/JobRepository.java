package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.jobs.JobsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobsEntity,Long> {


    // Get the latest Job by ID in descending order
    Optional<JobsEntity> findTopByOrderByJobCodeDesc();


//    // Find by job code with pagination
//    Page<JobsEntity> findByJobCodeContainingIgnoreCase(String jobCode, Pageable pageable);
//
//    // Find by job title with pagination
//    Page<JobsEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
//
//    // Find by status with pagination
//    Page<JobsEntity> findByStatus(Status status, Pageable pageable);

    // Count by active status
    long countByDelFlag(Integer delFlag);

    // Count by specific status
    long countByStatus(Status status);

    // Soft delete by setting isActive to 0 and status to CLOSED
    @Modifying
    @Query("UPDATE JobsEntity j SET j.delFlag = 0, j.status = 'COMPLETE' WHERE j.jobId = :jobId")
    void softDeleteJob(@Param("jobId") Long jobId);

//

    // Global search using only job code
    @Query("SELECT j FROM JobsEntity j WHERE :searchKey IS NULL OR LOWER(j.jobCode) LIKE LOWER(CONCAT('%', :searchKey, '%'))")
    Page<JobsEntity> globalSearch(@Param("searchKey") String searchKey, Pageable pageable);


}
