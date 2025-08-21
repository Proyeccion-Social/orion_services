package com.orion.savide.repository;

import com.orion.savide.entity.ProyectoStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoStatusRepository extends JpaRepository<ProyectoStatusRepository, ProyectoStatusEntity.ProyectoStatusId> {
}
