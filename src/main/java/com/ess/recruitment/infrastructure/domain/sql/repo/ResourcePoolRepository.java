package com.ess.recruitment.infrastructure.domain.sql.repo;

import com.ess.recruitment.infrastructure.domain.sql.model.ResourcePoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcePoolRepository extends JpaRepository<ResourcePoolEntity,Long> {

}
