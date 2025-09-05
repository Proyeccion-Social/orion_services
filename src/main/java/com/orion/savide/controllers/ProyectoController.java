package com.orion.savide.controllers;

import com.orion.savide.dto.DTOProyecto;
import com.orion.savide.services.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/get/{id}")
    private ResponseEntity<DTOProyecto> getProyectoById(@PathVariable Long id) {
        if (proyectoService.getProyectoById(id) != null) {
            return ResponseEntity.ok(proyectoService.getProyectoById(id));
        }
        return ResponseEntity.noContent().build();
    }
}
