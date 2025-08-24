package com.orion.savide.services;

import com.orion.savide.dto.DTOTecnologia;
import com.orion.savide.repository.TecnologiaRepository;
import com.orion.savide.utils.MapperTecnologia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TecnologiaService {
    private final TecnologiaRepository tecnologiaRepository;
    private final MapperTecnologia mapperTecnologia;

    public List<DTOTecnologia> getTecnologias() {
        List<DTOTecnologia> list = new ArrayList<>();
        tecnologiaRepository.findAll().forEach(Etecno -> {
            list.add(mapperTecnologia.entityToDTO(Etecno));
        });
        return list;
    }
}
