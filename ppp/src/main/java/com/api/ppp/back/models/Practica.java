package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "practica")
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

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "cov_id", referencedColumnName = "cov_id")
    private Convocatoria convocatoria;

    @ManyToOne
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "tin_id", referencedColumnName = "tin_id")
    private TutorInstituto tutorInstituto;

    @ManyToOne
    @JoinColumn(name = "tem_id", referencedColumnName = "tem_id")
    private TutorEmpresarial tutorEmpresarial;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "practica",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Anexos> anexos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Resultado> resultados;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SemanaActividad> semanasActividades;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Calificacion> calificaciones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Visita> visitas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practica", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AspectoPractica> aspectos;

}
