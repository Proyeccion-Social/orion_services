package com.orion.savide.repository;

import com.orion.savide.entity.IntegrantesEntity;
import com.orion.savide.entity.ProyectoEntity;
import com.orion.savide.entity.ProyectoGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoGeneralRepository extends JpaRepository<ProyectoGeneralEntity, ProyectoGeneralEntity.ProyectoGeneralId> {
    @Query("SELECT pg.integrante_id FROM ProyectoGeneralEntity pg WHERE pg.proyecto_id = :proyecto")
    List<IntegrantesEntity> findByProyecto(@Param("proyecto") ProyectoEntity proyecto);
}
