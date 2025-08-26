package com.orion.savide.services;

import com.orion.savide.dto.DTOProyectoStatus;
import com.orion.savide.repository.ProyectoStatusRepository;
import com.orion.savide.utils.MapperProyectoStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoStatusService {

    private final ProyectoStatusRepository proyectoStatusRepository;
    private final MapperProyectoStatus mapperProyectoStatus;

    public List<DTOProyectoStatus> listaProyectoStatus() {
        return mapperProyectoStatus.entitysToDTOs(proyectoStatusRepository.findAll());
    }
}
