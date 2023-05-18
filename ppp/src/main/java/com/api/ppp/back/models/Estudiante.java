package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Integer id;

    @Column(name = "est_periodo")
    @NotNull
    private String periodo;

    @Column(name = "est_ciclo")
    private String ciclo;

    @Column(name = "est_horas_cumplidas")
    private Integer horasCumplidas;

    @Column(name = "est_prioridad")
    private Boolean prioridad;

    // Foreign Key - Relationships

    @Column(name = "id_estudiante")
    @NotNull
    private Integer idEstudiante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @NotNull
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    @NotNull
    private Carrera carrera;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEstudiante> solicitudes;

}

