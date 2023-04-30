package com.api.ppp.back.models;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Integer id;

    @Column(name = "act_descripcion")
    private String descripcion;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "sol_id", referencedColumnName = "sol_id")
    private SolicitudEmpresa solicitudEmpresa;

    @ManyToOne
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id")
    private Materia materia;

}
