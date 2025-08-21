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
    @ManyToOne(fetch = FetchType.LAZY)
    private ProyectoEntity proyecto_id;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusEntity state_id;


    private Date date;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProyectoStatusId implements Serializable {
        private Long proyecto_id;
        private Long state_id;
    }
}
