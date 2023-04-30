package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "materia")
public class Materia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_id")
    private Integer id;

    @Column(name = "id_materia")
    private Integer idMateria;

    @Column(name = "mat_nombre")
    private String nombre;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Carrera carrera;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ObjetivoMateria> objetivoMaterias;

    @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tarea> tareas;

    @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Actividad> actividades;

}
