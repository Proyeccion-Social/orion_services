package com.orion.savide.repository;

import com.orion.savide.entity.ProyectoGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoGeneralRepository extends JpaRepository<ProyectoGeneralEntity, ProyectoGeneralEntity.ProyectoGeneralId> {
}
