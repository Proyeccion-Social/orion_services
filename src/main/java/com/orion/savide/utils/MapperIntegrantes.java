package com.orion.savide.utils;

import com.orion.savide.dto.DTOIntegrantes;
import com.orion.savide.entity.IntegrantesEntity;
import com.orion.savide.entity.ProyectoGeneralEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperIntegrantes {

    public DTOIntegrantes entityToDTO(IntegrantesEntity integranteEntity) {
        return DTOIntegrantes.builder()
                .username(integranteEntity.getUsername())
                .created_at(integranteEntity.getCreated_at())
                .build();
    }
}
