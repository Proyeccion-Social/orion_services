package com.orion.savide.controllers;

import com.orion.savide.dto.DTOIntegrantes;
import com.orion.savide.services.IntegranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orion/integrantes")
@RequiredArgsConstructor
public class IntegrantesController {

    private final IntegranteService integranteService;

    @GetMapping("/get_all")
    private ResponseEntity<List<DTOIntegrantes>> getAll() {
        return ResponseEntity.ok(integranteService.getIntegrantes());
    }
}
