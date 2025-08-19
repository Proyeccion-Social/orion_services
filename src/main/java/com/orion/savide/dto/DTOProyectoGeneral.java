package com.orion.savide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOProyectoGeneral {
    private String nombre_proyecto;
    private String descripcion_proyecto;
    private List<DTOIntegrantes> integrantes;
    private List<DTOTecnologia> tecnologias;
    private List<DTORol> roles;
}
