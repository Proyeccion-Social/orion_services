package com.orion.savide.utils;

import com.orion.savide.dto.DTORol;
import com.orion.savide.entity.RolEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperRol {

    public DTORol entityToDTO(RolEntity entity) {
        return DTORol.builder()
                .rol(entity.getName())
                .build();
    }
}
