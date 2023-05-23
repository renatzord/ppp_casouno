package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "tarea")
public class Tarea implements Serializable {

    @Id
    @Column(name = "tar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "La descripcióm es obligatoria.")
    @Column(name = "tar_descripcion")
    private String descripcion;

    // Foreign Key - Relationships

    @NotNull(message = "La materia es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "mat_id",referencedColumnName = "mat_id")
    private Materia materia;

    @NotNull(message = "La actividad es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "act_id", referencedColumnName = "act_id")
    private Actividad actividad;

    @NotNull(message = "La práctica es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private Practica practica;

    // Bidirectional Relationships

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarea", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleTarea> detalleTareas;

}
