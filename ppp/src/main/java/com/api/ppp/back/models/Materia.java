package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty(message = "El nombre es obligatorio")
    @Column(name = "mat_nombre")
    private String nombre;

    // Foreign Key - Relationships

    @NotNull(message = "La carrera es obligatoria")
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
