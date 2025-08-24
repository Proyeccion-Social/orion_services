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
    @Column(name = "proyecto_id")
    private Long proyecto_id;

    @Id
    @Column(name = "integrante_id")
    private Long integrante_id;

    @Id
    @Column(name = "tecnologia_id")
    private Long tecnologia_id;

    @Id
    @Column(name = "rol_id")
    private Long rol_id;

    // Relaciones
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_id", insertable = false, updatable = false)
    private ProyectoEntity proyecto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "integrante_id", insertable = false, updatable = false)
    private IntegrantesEntity integrante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tecnologia_id", insertable = false, updatable = false)
    private TecnologiaEntity tecnologia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private RolEntity rol;

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
