package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "objetivo_materia")
public class ObjetivoMateria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obm_id")
    private Integer id;

    @NotEmpty(message = "La descripción es obligatoria")
    @Column(name = "obm_descripcion")
    private String descripcion;

    // Foreign Key - Relationships

    @NotNull(message = "La materia es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "mat_id", referencedColumnName = "mat_id")
    private Materia materia;

}