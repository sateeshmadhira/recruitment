package com.ess.recruitment.infrastructure.domain.sql.repository;

import com.ess.recruitment.core.utils.Status;
import com.ess.recruitment.infrastructure.domain.sql.model.InterviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterviewRepository extends JpaRepository<InterviewEntity,Long> {
    Optional<InterviewEntity> findTopByOrderByInterviewCodeDesc();
    long countByDelFlag(Integer delFlag);


    long countByStatus(Status status);


    @Modifying
    @Query("UPDATE InterviewEntity i SET i.delFlag = 0, i.status = :status WHERE i.interviewId = :interviewId")
    void softDeleteJob(@Param("interviewId") Long interviewId);




    @Query("SELECT i FROM InterviewEntity i WHERE :searchKey IS NULL OR LOWER(i.interviewCode) LIKE LOWER(CONCAT('%', :searchKey, '%'))")
    Page<InterviewEntity> globalSearch(@Param("searchKey") String searchKey, Pageable pageable);



}
