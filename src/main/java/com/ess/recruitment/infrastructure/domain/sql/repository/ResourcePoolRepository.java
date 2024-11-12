package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import jakarta.persistence.Table;
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
public interface ResourcePoolRepository extends JpaRepository<ResourcePoolEntity,Long> {
    Optional<ResourcePoolEntity> findTopByOrderByResourceCodeDesc();
    long countByDelFlag(Integer delFlag);
    long countByStatus(Status status);

    @Modifying
    @Transactional
    @Query("UPDATE ResourcePoolEntity r SET r.delFlag = 0, r.status = :status WHERE r.poolId = :resourcePoolId")
    void softDeleteResource(@Param("resourcePoolId") Long resourcePoolId, @Param("status") Status status);


    // Global search using only job code
    @Query("SELECT r FROM ResourcePoolEntity r WHERE :searchKey IS NULL OR LOWER(r.resourceCode) LIKE LOWER(CONCAT('%', :searchKey, '%'))")
    Page<ResourcePoolEntity> globalSearch(@Param("searchKey") String searchKey, Pageable pageable);


}
