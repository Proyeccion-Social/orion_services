package com.orion.savide.services;

import com.orion.savide.dto.DTOProyecto;
import com.orion.savide.entity.ProyectoEntity;
import com.orion.savide.repository.ProyectoRepository;
import com.orion.savide.utils.MapperProyecto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;
    private final MapperProyecto mapperProyecto;

    public List<DTOProyecto> getProyectos() {
        List<DTOProyecto> dtoProyectos = new ArrayList<>();
        proyectoRepository.findAll().forEach(Eproyecto -> {
             dtoProyectos.add(mapperProyecto.entityToDTO(Eproyecto));
        });
        return dtoProyectos;
    }
}
