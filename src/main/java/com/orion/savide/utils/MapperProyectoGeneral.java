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


    public DTOProyectoGeneral entityToDTO(ProyectoGeneralEntity proyectoGeneralEntity) {
        Map<DTOIntegrantes, Set<DTORol>> listaIntegrantes = new HashMap<>();
        //listaIntegrantes.put(mapperIntegrantes.entityToDTO(proyectoGeneralEntity.getIntegrante()), mapperRol.entityToDTO(proyectoGeneralEntity.getRol()));

        List<DTOTecnologia> listaTecnologias = new ArrayList<>();
        listaTecnologias.add(mapperTecnologia.entityToDTO(proyectoGeneralEntity.getTecnologia()));

        return DTOProyectoGeneral.builder()
                .nombre_proyecto(proyectoGeneralEntity.getProyecto().getTitle())
                .descripcion_proyecto(proyectoGeneralEntity.getProyecto().getDescription())
                .integrantes(listaIntegrantes)
                .tecnologias(listaTecnologias)
                .build();
    }
}
