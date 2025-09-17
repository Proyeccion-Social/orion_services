package com.orion.savide.controllers;

import com.orion.savide.dto.DTOTecnologia;
import com.orion.savide.services.TecnologiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orion/tecnologias")
@RequiredArgsConstructor
public class TecnologiaController {

    private final TecnologiaService tecnologiaService;

    @GetMapping("/get_all")
    private ResponseEntity<List<DTOTecnologia>> getAll() {
        return ResponseEntity.ok(tecnologiaService.getTecnologias());
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        if (tecnologiaService.getTecnologiaById(id) != null) {
            return ResponseEntity.ok(tecnologiaService.getTecnologiaById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La tecnologia de id: " + id + " no existe.");
    }
}
