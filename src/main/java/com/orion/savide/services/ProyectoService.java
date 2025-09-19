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

    public DTOProyecto getProyectoById(Long id) {
        ProyectoEntity proyecto = proyectoRepository.findById(id).orElse(null);
        if(proyecto == null) {
            return null;
        }
        return mapperProyecto.entityToDTO(proyecto);
    }

    public boolean saveProyecto(DTOProyecto dto){
        ProyectoEntity entity = mapperProyecto.dtoToEntity(dto);
        if(entity == null) {
            return false;
        }
        proyectoRepository.save(entity);
        return true;
    }
}
