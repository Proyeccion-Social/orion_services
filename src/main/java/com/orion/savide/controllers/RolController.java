package com.orion.savide.controllers;

import com.orion.savide.dto.DTORol;
import com.orion.savide.services.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orion/rol")
@RequiredArgsConstructor
public class RolController {
    private final RolService rolService;

    @GetMapping("/get_all")
    private ResponseEntity<List<DTORol>> getAll() {
        return ResponseEntity.ok(rolService.getRols());
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<DTORol> get(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.getRolById(id));
    }
}
