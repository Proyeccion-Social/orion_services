package com.orion.savide.repository;

import com.orion.savide.entity.TecnologiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<TecnologiaEntity, Long> {
}
