package com.api.ppp.back.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Integer id;

    @NotEmpty(message = "La descripción es obligatoria")
    @Column(name = "act_descripcion")
    private String descripcion;

    // Foreign Key - Relationships

    @ManyToOne(optional = false)
    @JoinColumn(name = "sol_id", referencedColumnName = "sol_id", nullable = false)
    private SolicitudEmpresa solicitudEmpresa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id", nullable = false)
    private Materia materia;

    // Bidirectional Relationships

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tarea> tareas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Resultado> resultados;

}

