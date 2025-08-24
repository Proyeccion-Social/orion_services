package com.orion.savide.services;

import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.repository.ProyectoGeneralRepository;
import com.orion.savide.utils.MapperProyectoGeneral;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoGeneralService {
    private final ProyectoGeneralRepository proyectosGeneralRepository;
    private final MapperProyectoGeneral mapperProyectoGeneral;

    public List<DTOProyectoGeneral> listProyectosGeneral() {
        List<DTOProyectoGeneral> listProyectoGeneral = new ArrayList<>();
        proyectosGeneralRepository.findAll().forEach(entity ->{
            listProyectoGeneral.add(mapperProyectoGeneral.entityToDTO(entity));
        });
        return listProyectoGeneral;
    };
}
