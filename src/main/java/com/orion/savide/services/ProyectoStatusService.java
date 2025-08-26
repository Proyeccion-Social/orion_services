package com.orion.savide.services;

import com.orion.savide.repository.ProyectoStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProyectoStatusService {

    private final ProyectoStatusRepository proyectoStatusRepository;
}
