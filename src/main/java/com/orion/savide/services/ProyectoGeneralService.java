package com.orion.savide.services;

import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.dto.DTOTecnologia;
import com.orion.savide.repository.ProyectoGeneralRepository;
import com.orion.savide.utils.MapperIntegrantes;
import com.orion.savide.utils.MapperProyectoGeneral;
import com.orion.savide.utils.MapperRol;
import com.orion.savide.utils.MapperTecnologia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProyectoGeneralService {
    private final ProyectoGeneralRepository proyectosGeneralRepository;
    private final MapperProyectoGeneral mapperProyectoGeneral;
    private final MapperIntegrantes mapperIntegrantes;
    private final MapperRol mapperRol;
    private final MapperTecnologia mapperTecnologia;

    public List<DTOProyectoGeneral> listProyectosGeneral() {
        Map<Long, DTOProyectoGeneral> proyectosMap = new HashMap<>();

        proyectosGeneralRepository.findAll().forEach(entity -> {
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
