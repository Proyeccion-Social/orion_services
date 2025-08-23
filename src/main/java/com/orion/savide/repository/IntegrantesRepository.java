package com.orion.savide.repository;

import com.orion.savide.entity.IntegrantesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegrantesRepository extends JpaRepository<IntegrantesEntity, Long> {
}
