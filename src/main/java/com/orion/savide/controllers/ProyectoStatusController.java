package com.orion.savide.controllers;

import com.orion.savide.dto.DTOProyectoStatus;
import com.orion.savide.services.ProyectoStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orion/proyecto_status")
@RequiredArgsConstructor
public class ProyectoStatusController {

    private final ProyectoStatusService proyectoStatusService;

    @GetMapping("/get_all")
    private ResponseEntity<List<DTOProyectoStatus>> getAll() {
        return ResponseEntity.ok(proyectoStatusService.listaProyectoStatus());
    }

}
