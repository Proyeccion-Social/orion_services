package com.orion.savide.services;

import com.orion.savide.dto.DTOIntegrantes;
import com.orion.savide.entity.IntegrantesEntity;
import com.orion.savide.repository.IntegrantesRepository;
import com.orion.savide.utils.MapperIntegrantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IntegranteService {
    private final IntegrantesRepository integrantesRepository;
    private final MapperIntegrantes mapper;

    public List<DTOIntegrantes> getIntegrantes() {
        List<DTOIntegrantes> dtoIntegrantes = new ArrayList<>();
        List<IntegrantesEntity> entities = integrantesRepository.findAll();
        for (IntegrantesEntity entity : entities) {
            dtoIntegrantes.add(mapper.EntityToDTO(entity));
        }
        return dtoIntegrantes;
    }
}
