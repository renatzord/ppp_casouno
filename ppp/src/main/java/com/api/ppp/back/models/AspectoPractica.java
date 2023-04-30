package com.api.ppp.back.models;

import jakarta.persistence.*;
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
    private Boolean respuesta;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "aps_id",referencedColumnName = "aps_id")
    private Aspecto aspecto;

    @ManyToOne
    @JoinColumn(name = "pra_id",referencedColumnName = "pra_id")
    private Practica practica;

}
