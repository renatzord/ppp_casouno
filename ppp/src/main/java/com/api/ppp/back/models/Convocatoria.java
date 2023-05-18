package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "convocatoria")
public class Convocatoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cov_id")
    private Integer id;

    @Column(name = "cov_fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "cov_fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "cov_numero", nullable = false, unique = true)
    private Integer numero;

    // Foreign Key - Relationships

    @ManyToOne(optional = false)
    @JoinColumn(name = "sol_id", nullable = false)
    private SolicitudEmpresa solicitudEmpresa;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEstudiante> solicitudEstudiantes;

    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AccionConvoca> accionConvocas;

    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;


}

