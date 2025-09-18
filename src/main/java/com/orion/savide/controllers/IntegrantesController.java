package com.orion.savide.controllers;

import com.orion.savide.dto.DTOIntegrantes;
import com.orion.savide.services.IntegranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    @GetMapping("/get/{id}")
    private ResponseEntity<?> get(@PathVariable Long id) {
        if(integranteService.getIntegranteById(id) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El integrante de id " + id + " no existe");
        }
        return ResponseEntity.ok(integranteService.getIntegranteById(id));
    }

    @PostMapping("/save")
    private ResponseEntity<?> save(@RequestParam String username) {

        LocalDateTime bogotaTime = LocalDateTime.now(ZoneId.of("America/Bogota"));
        Timestamp now = Timestamp.valueOf(bogotaTime);

        DTOIntegrantes dtoIntegrantes = DTOIntegrantes.builder()
                .username(username)
                .created_at(now)
                .build();

        boolean creado = integranteService.crearIntegrante(dtoIntegrantes);

        if (creado) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El integrante no es valido");
    }


}
