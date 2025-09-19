package com.orion.savide.controllers;

import com.orion.savide.dto.DTOProyecto;
import com.orion.savide.services.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    private ResponseEntity<?> getProyectoById(@PathVariable Long id) {
        if (proyectoService.getProyectoById(id) != null) {
            return ResponseEntity.ok(proyectoService.getProyectoById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El proyecto de id: " + id + " no existe.");
    }

    @PostMapping("/save")
    private ResponseEntity<?> saveProyecto(@RequestParam String title, @RequestParam String description) {
        LocalDateTime bogotaTime = LocalDateTime.now(ZoneId.of("America/Bogota"));
        Timestamp now = Timestamp.valueOf(bogotaTime);

        DTOProyecto dto = DTOProyecto.builder()
                .title(title)
                .description(description)
                .created_at(now).build();
        boolean creado = proyectoService.saveProyecto(dto);
        if(creado){
            return ResponseEntity.status(HttpStatus.CREATED).body("El proyecto fue creado correctamente");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El proyecto no ha podido ser creado");
    }
}
