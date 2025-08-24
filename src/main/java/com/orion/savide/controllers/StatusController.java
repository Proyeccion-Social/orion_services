package com.orion.savide.controllers;

import com.orion.savide.dto.DTOStatus;
import com.orion.savide.services.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orion/status")
@RequiredArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @GetMapping("/get_all")
    private ResponseEntity<List<DTOStatus>> getAll() {
        return ResponseEntity.ok(statusService.getStatusList());
    }
}
