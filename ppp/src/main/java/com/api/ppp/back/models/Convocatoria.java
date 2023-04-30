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

    @Column(name = "cov_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "cov_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "cov_numero")
    private Integer numero;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "sol_id")
    private SolicitudEmpresa solicitudEmpresa;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "convocatoria",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEstudiante> solicitudEstudiantes;

    @OneToMany(mappedBy = "convocatoria",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AccionConvoca> accionConvocas;

    @OneToMany(mappedBy = "convocatoria",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;

}
