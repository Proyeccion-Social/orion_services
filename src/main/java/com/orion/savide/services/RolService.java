package com.orion.savide.services;

import com.orion.savide.dto.DTORol;
import com.orion.savide.repository.ProyectoRepository;
import com.orion.savide.repository.RolRepository;
import com.orion.savide.utils.MapperRol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {
    private final RolRepository rolRepository;
    private final MapperRol mapperRol;

    public List<DTORol> getRols() {
        List<DTORol> dtoRols = new ArrayList<>();
        rolRepository.findAll().forEach(Erol -> {
            dtoRols.add(mapperRol.entityToDTO(Erol));
        });
        return dtoRols;
    }
}
