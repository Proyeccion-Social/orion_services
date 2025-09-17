package com.orion.savide.repository;

import com.orion.savide.entity.ProyectoGeneralEntity;
import com.orion.savide.entity.ProyectoStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoStatusRepository extends JpaRepository<ProyectoStatusEntity, ProyectoStatusEntity.ProyectoStatusId> {
    @Query("SELECT pg FROM ProyectoStatusEntity pg WHERE pg.proyecto_id =:id")
    List<ProyectoStatusEntity> findAllById(@Param("id") Long id);
}
