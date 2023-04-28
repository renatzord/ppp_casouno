package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

    @Id
    @Column(name = "pra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pra_periodo")
    private String periodo;

    @Column(name = "pra_nsemanas")
    private Integer nsemanas;

    @Column(name = "pra_inicio")
    private Date inicio;

    @Column(name = "pra_fin")
    private Date fin;

    @Column(name = "pra_concluciones")
    private String concluciones;

    @Column(name = "pra_departamento")
    private String departamento;

    @ManyToOne
    @JoinColumn(name = "pra_id",referencedColumnName = "pra_id")
    private Practica practica;
}
