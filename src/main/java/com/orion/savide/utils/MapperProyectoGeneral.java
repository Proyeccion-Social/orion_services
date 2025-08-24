package com.orion.savide.utils;

import com.orion.savide.dto.DTOIntegrantes;
import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.dto.DTORol;
import com.orion.savide.dto.DTOTecnologia;
import com.orion.savide.entity.ProyectoGeneralEntity;
import com.orion.savide.repository.ProyectoGeneralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperProyectoGeneral {

    private final ProyectoGeneralRepository proyectosGeneralRepository;
    private final MapperIntegrantes mapperIntegrantes;
    private final MapperTecnologia mapperTecnologia;
    private final MapperRol mapperRol;


    public DTOProyectoGeneral entityToDTO(ProyectoGeneralEntity proyectoGeneralEntity) {
        List<DTOIntegrantes> listaIntegrantes = new ArrayList<>();
        proyectosGeneralRepository.findAll().forEach(entity ->{
            listaIntegrantes.add(mapperIntegrantes.EntityToDTO(entity.getIntegrante()));
        });
//        List<DTOTecnologia> listaTecnologias;
//        List<DTORol> listaRol;
        return DTOProyectoGeneral.builder()
                .nombre_proyecto(proyectoGeneralEntity.getProyecto().getTitle())
                .descripcion_proyecto(proyectoGeneralEntity.getProyecto().getDescription())
                .integrantes(listaIntegrantes)
                .build();
    }
}
