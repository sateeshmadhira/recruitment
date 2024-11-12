package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.CandidateSubmissionEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateSubmissionRepository extends JpaRepository<CandidateSubmissionEntity, Long> {

    // Get the latest candidate by ID in descending order
    Optional<CandidateSubmissionEntity> findTopByOrderByCandidateCodeDesc();

    // Count by active status (e.g., candidates flagged for deletion or inactive status)
    long countByDelFlag(Integer delFlag);

    // Count by specific status
    long countByStatus(Status status);

    // Soft delete by setting isActive to 0 and status to COMPLETE
    @Modifying
    @Transactional
    @Query("UPDATE CandidateSubmissionEntity c SET c.delFlag = 0, c.status = 'COMPLETE' WHERE c.id = :id")
    void softDeleteCandidate(@Param("id") Long id);

    // Global search using candidate code
    @Query("SELECT c FROM CandidateSubmissionEntity c WHERE :searchKey IS NULL OR LOWER(c.candidateCode) LIKE LOWER(CONCAT('%', :searchKey, '%'))")
    Page<CandidateSubmissionEntity> globalSearch(@Param("searchKey") String searchKey, Pageable pageable);
}
