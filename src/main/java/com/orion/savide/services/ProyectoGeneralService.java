package com.orion.savide.services;

import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.repository.ProyectoGeneralRepository;
import org.springframework.stereotype.Service;

@Service
public class ProyectoGeneralService {
    private ProyectoGeneralRepository proyectosGeneralRepository;

    private DTOProyectoGeneral GetProyectoGeneralByIdProyect(Long idProyecto) {
        DTOProyectoGeneral proyectoGeneral = new DTOProyectoGeneral();
        return proyectoGeneral;
    };
}
