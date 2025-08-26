package com.orion.savide.controllers;

import com.orion.savide.services.ProyectoStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orion/proyecto_status")
@RequiredArgsConstructor
public class ProyectoStatusController {

    private final ProyectoStatusService proyectoStatusService;

}
