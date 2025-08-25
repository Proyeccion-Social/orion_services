package com.orion.savide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOProyectoGeneral {
    private String nombre_proyecto;
    private String descripcion_proyecto;
    private Map<DTOIntegrantes, Set<DTORol>> integrantes;
    private List<DTOTecnologia> tecnologias;
}
