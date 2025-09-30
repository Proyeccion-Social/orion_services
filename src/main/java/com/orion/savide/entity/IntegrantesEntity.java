package com.orion.savide.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "integrantes")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IntegrantesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @Column(name = "start")
    private Date created_at;
}
