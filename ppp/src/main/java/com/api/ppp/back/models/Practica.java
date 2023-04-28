package com.api.ppp.back.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Practica implements Serializable {

    @Id
    @Column(name = "pra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pra_periodo")
    private String periodo;

    @Column(name = "pra_nsemanas")
    private Integer nSemanas;

    @Column(name = "pra_inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;

    @Column(name = "pra_fin")
    @Temporal(TemporalType.DATE)
    private Date fin;

    @Column(name = "pra_concluciones")
    private String concluciones;

    @Column(name = "pra_departamento")
    private String departamento;

    @ManyToOne
    @JoinColumn(name = "cov_id", referencedColumnName = "cov_id")
    private Convocatoria convocatoria;

    @ManyToOne
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "tin_id", referencedColumnName = "tin_id")
    private TutorInstituto tutorInstituo;

    @ManyToOne
    @JoinColumn(name = "tem_id", referencedColumnName = "tem_id")
    private TutorEmpresarial tutorEmpresarial;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    private List<Anexos> anexos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    private List<Resultado> resultados;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    private List<SemanaActividad> semanasActividades;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    private List<Calificacion> calificaciones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    private List<Visita> visitas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    private List<AspectoPractica> aspectos;


}
