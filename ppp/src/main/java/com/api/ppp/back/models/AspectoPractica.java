package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "aspecto_practica")
public class AspectoPractica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apr_id")
    private Integer id;

    @Column(name = "apr_respuesta")
    private Boolean respuesta = false;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "apr_aps_id", referencedColumnName = "aps_id", nullable = false)
    @NotNull
    private Aspecto aspecto;

    @ManyToOne
    @JoinColumn(name = "apr_pra_id", referencedColumnName = "pra_id", nullable = false)
    @NotNull
    private Practica practica;

    // Bidirectional Relationships

}

