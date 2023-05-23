package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "estudiante", uniqueConstraints = {
        @UniqueConstraint(columnNames = "usu_id")
})
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Integer id;

    @Column(name = "est_periodo")
    private String periodo;

    @Column(name = "est_ciclo")
    private Integer ciclo;

    @Column(name = "est_horas_cumplidas")
    private Integer horasCumplidas;

    @Column(name = "est_prioridad")
    private Boolean prioridad = false;

    // Foreign Key - Relationships

    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @NotNull(message = "El usuario es obligatorio")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Carrera carrera;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEstudiante> solicitudes;

}
