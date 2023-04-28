package com.api.ppp.back.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

public class Resultado implements Serializable {

    @Id
    @Column(name = "rel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* @ManyToOne
    @JoinColumn(name = "rem_id",referencedColumnName = "rem_id")
    private ResultadoMateria resultadoMateria;*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultado",fetch = FetchType.LAZY)
    private List<Tarea> tareas;

    @ManyToOne
    @JoinColumn(name = "pra_id",referencedColumnName = "pra_id")
    private Practica practica;

}
