package com.orion.savide.utils;

import com.orion.savide.dto.DTOProyecto;
import com.orion.savide.entity.ProyectoEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperProyecto {

    public DTOProyecto entityToDTO(ProyectoEntity proyectoEntity) {
        return DTOProyecto.builder()
                .title(proyectoEntity.getTitle())
                .description(proyectoEntity.getDescription())
                .created_at(proyectoEntity.getCreated_at())
                .build();
    }
}
