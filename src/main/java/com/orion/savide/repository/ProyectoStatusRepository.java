package com.orion.savide.repository;

import com.orion.savide.entity.ProyectoStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoStatusRepository extends JpaRepository<ProyectoStatusEntity, ProyectoStatusEntity.ProyectoStatusId> {
}
