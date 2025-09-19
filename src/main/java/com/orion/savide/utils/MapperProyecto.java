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

    public ProyectoEntity dtoToEntity(DTOProyecto dtoProyecto) {
        return ProyectoEntity.builder()
                .title(dtoProyecto.getTitle())
                .description(dtoProyecto.getDescription())
                .created_at(dtoProyecto.getCreated_at())
                .build();
    }
}
