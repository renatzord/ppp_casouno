package com.api.ppp.back.models;

import jakarta.persistence.*;
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
    private String periodo;

    @Column(name = "est_ciclo")
    private String ciclo;

    @Column(name = "est_horas_cumplidas")
    private Integer horasCunplidas;

    @Column(name = "est_prioridad")
    private Boolean prioridad;

    // Foreign Key - Relationships

    @Column(name = "est_id_estudiante")
    private String id_estudiante;

    @OneToOne
    @JoinColumn(name = "est_usu_id")
    private Usuario usuario;

    //@OneTo
    //@JoinColumn(name = "est_car_id")
    //private Carrera carrera;

    // Bidirectional Relationships

    /*@OneToMany(mappedBy = "estudiante")
    @JsonIgnore
    private List<Practica> practicas;*/

}
