package com.orion.savide.controllers;

import com.orion.savide.dto.DTOProyecto;
import com.orion.savide.services.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orion/proyectos")
@RequiredArgsConstructor
public class ProyectoController {
    private final ProyectoService proyectoService;

    @GetMapping("/get_all")
    private ResponseEntity<List<DTOProyecto>> getAllProyectos() {
        return ResponseEntity.ok(proyectoService.getProyectos());
    }
}
