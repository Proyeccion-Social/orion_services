package com.orion.savide.utils;

import com.orion.savide.dto.DTOStatus;
import com.orion.savide.entity.StatusEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperStatus {

    public DTOStatus entityToDTO(StatusEntity statusEntity) {
        return DTOStatus.builder()
                .state(statusEntity.getState())
                .build();
    }
}
