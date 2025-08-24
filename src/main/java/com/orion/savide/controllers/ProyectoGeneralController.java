package com.orion.savide.controllers;

import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.services.ProyectoGeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orion/proyectos_generales")
@RequiredArgsConstructor
public class ProyectoGeneralController {
    private final ProyectoGeneralService proyectoGeneralService;

    @GetMapping("/get_all")
    private ResponseEntity<List<DTOProyectoGeneral>> getAll(){
        return ResponseEntity.ok(proyectoGeneralService.listProyectosGeneral());
    }
}
