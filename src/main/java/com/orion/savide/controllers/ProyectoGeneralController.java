package com.orion.savide.controllers;

import com.orion.savide.dto.DTOProyectoGeneral;
import com.orion.savide.services.ProyectoGeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/get/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id){
        if(proyectoGeneralService.getById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro general de proyecto con id: " + id + " no existe.");
        }
        return ResponseEntity.ok(proyectoGeneralService.getById(id));
    }
}
