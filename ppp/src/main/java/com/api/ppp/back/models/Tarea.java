package com.api.ppp.back.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

public class Tarea implements Serializable {

    @Id
    @Column(name = "tar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tar_descripcion")
    private String descripcion;

    /* @ManyToOne
    @JoinColumn(name = "act_id",referencedColumnName = "act_id")
    private Actividad actividad;*/

    /* @ManyToOne
    @JoinColumn(name = "mat_id",referencedColumnName = "mat_id")
    private Materia materia;*/

    @ManyToOne
    @JoinColumn(name = "rel_id", referencedColumnName = "rel_id")
    private Resultado resultado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarea", fetch = FetchType.LAZY)
    private List<DetalleTarea> detalleTareas;

}
