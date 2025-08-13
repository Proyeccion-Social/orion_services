package com.orion.savide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "proyecto_status")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProyectoStatus {
    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private ProyectoEntity proyecto_id;

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private StatusEntity state_id;

    private Date created_at;
}
