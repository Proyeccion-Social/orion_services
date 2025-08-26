package com.orion.savide.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "proyecto_status")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
@IdClass(ProyectoStatusEntity.ProyectoStatusId.class)
public class ProyectoStatusEntity {
    @Id
    @Column(name = "proyecto_id")
    private Long proyecto_id;
    @Id
    @Column(name = "state_id")
    private Long state_id;

    @JoinColumn(name = "proyecto_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ProyectoEntity proyecto;

    @JoinColumn(name = "state_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private StatusEntity status;


    private Date date;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProyectoStatusId implements Serializable {
        private Long proyecto_id;
        private Long state_id;
    }
}
