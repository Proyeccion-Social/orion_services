package com.orion.savide.utils;

import com.orion.savide.dto.DTOProyectoStatus;
import com.orion.savide.entity.ProyectoStatusEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class MapperProyectoStatus {

    private final MapperStatus mapperStatus;

    public List<DTOProyectoStatus> entitysToDTOs(List<ProyectoStatusEntity> entitys) {
        Map<Long, DTOProyectoStatus> map = new HashMap<>();

        entitys.forEach(entity -> {
            Long proyectoId = entity.getProyecto_id();
            DTOProyectoStatus dto = map.get(proyectoId);
            if (dto == null) {
                dto = DTOProyectoStatus.builder()
                        .nombre_proyecto(entity.getProyecto().getTitle())
                        .historial(new HashMap<>())
                        .build();

                map.put(proyectoId, dto);
            }

            dto.getHistorial().computeIfAbsent(mapperStatus.entityToDTO(entity.getStatus()), k -> new HashSet<>()).add(entity.getDate());

        });

        return new ArrayList<>(map.values());
    }
}
