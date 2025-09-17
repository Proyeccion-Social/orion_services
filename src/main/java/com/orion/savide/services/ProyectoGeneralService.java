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

    public List<DTOProyectoGeneral> listProyectosGeneral() {
        return mapperProyectoGeneral.entitysToDTO(proyectosGeneralRepository.findAll());
    }

    public List<DTOProyectoGeneral> getById(Long id){
        return mapperProyectoGeneral.entitysToDTO(proyectosGeneralRepository.findAllById(id));
    }
}
