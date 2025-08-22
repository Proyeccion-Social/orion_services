package com.orion.savide.utils;

import com.orion.savide.dto.DTOIntegrantes;
import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.dto.DTORol;
import com.orion.savide.dto.DTOTecnologia;
import com.orion.savide.entity.ProyectoGeneralEntity;
import com.orion.savide.repository.ProyectoGeneralRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperProyectoGeneral {

    private ProyectoGeneralRepository proyectosGeneralRepository;


    private DTOProyectoGeneral EntityToDTO(ProyectoGeneralEntity proyectoGeneralEntity) {
        List<DTOIntegrantes> listaIntegrantes = proyectosGeneralRepository;
        List<DTOTecnologia> listaTecnologias;
        List<DTORol> listaRol;
        return DTOProyectoGeneral.builder()
                .nombre_proyecto(proyectoGeneralEntity.getProyecto_id().getTitle())
                .descripcion_proyecto(proyectoGeneralEntity.getProyecto_id().getDescription())
                .build();
    }
}
