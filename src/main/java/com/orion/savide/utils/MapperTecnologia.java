package com.orion.savide.utils;

import com.orion.savide.dto.DTOTecnologia;
import com.orion.savide.entity.TecnologiaEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperTecnologia {

    public DTOTecnologia entityToDTO(TecnologiaEntity entity) {
        return DTOTecnologia.builder()
                .name(entity.getName())
                .build();
    }
}
