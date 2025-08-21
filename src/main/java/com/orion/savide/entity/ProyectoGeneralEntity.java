package com.orion.savide.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "proyectos_generales")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
@IdClass(ProyectoGeneralEntity.ProyectoGeneralId.class)
public class ProyectoGeneralEntity {
    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private ProyectoEntity proyecto_id;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private IntegrantesEntity integrante_id;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private TecnologiaEntity tecnologia_id;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private RolEntity rol_id;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProyectoGeneralId implements Serializable {
        private Long proyecto_id;
        private Long integrante_id;
        private Long tecnologia_id;
        private Long rol_id;
    }
}
