package com.orion.savide.utils;

import com.orion.savide.dto.DTOIntegrantes;
import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.dto.DTORol;
import com.orion.savide.dto.DTOTecnologia;
import com.orion.savide.entity.ProyectoGeneralEntity;
import com.orion.savide.repository.ProyectoGeneralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class MapperProyectoGeneral {

    private final MapperIntegrantes mapperIntegrantes;
    private final MapperTecnologia mapperTecnologia;
    private final MapperRol mapperRol;


    public List<DTOProyectoGeneral> entitysToDTO(List<ProyectoGeneralEntity> entitys) {
        Map<Long, DTOProyectoGeneral> proyectosMap = new HashMap<>();

        entitys.forEach(entity -> {

            Long proyectoId = entity.getProyecto_id();
            DTOProyectoGeneral dto = proyectosMap.get(proyectoId);
            if (dto == null) {
                dto = DTOProyectoGeneral.builder()
                        .nombre_proyecto(entity.getProyecto().getTitle())
                        .descripcion_proyecto(entity.getProyecto().getDescription())
                        .integrantes(new HashMap<>())
                        .tecnologias(new ArrayList<>())
                        .build();

                proyectosMap.put(proyectoId, dto);
            }

            dto.getIntegrantes()
                    .computeIfAbsent(mapperIntegrantes.entityToDTO(entity.getIntegrante()), k -> new HashSet<>())
                    .add(mapperRol.entityToDTO(entity.getRol()));

            // Agregar tecnología si no está repetida
            DTOTecnologia tecnologiaDTO = mapperTecnologia.entityToDTO(entity.getTecnologia());
            if (!dto.getTecnologias().contains(tecnologiaDTO)) {
                dto.getTecnologias().add(tecnologiaDTO);
            }
        });

        return new ArrayList<>(proyectosMap.values());
    }
}
