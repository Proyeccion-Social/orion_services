package com.orion.savide.services;

import com.orion.savide.dto.DTOStatus;
import com.orion.savide.repository.StatusRepository;
import com.orion.savide.utils.MapperStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;
    private final MapperStatus mapperStatus;

    public List<DTOStatus> getStatusList() {
        List<DTOStatus> dtoStatusList = new ArrayList<>();
        statusRepository.findAll().forEach(Estatus -> {
            dtoStatusList.add(mapperStatus.entityToDTO(Estatus));
        });
        return dtoStatusList;
    }
}
