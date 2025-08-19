package com.orion.savide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOProyectoStatus {
    private String nombre_proyecto;
    private List<DTOStatus> estado_proyecto;
    private List<Date> estados;
}
