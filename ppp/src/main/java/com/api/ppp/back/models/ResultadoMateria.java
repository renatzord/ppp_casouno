package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "resultado_materia")
public class ResultadoMateria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rem_id")
    private Integer id;

    @NotNull(message = "La descripción es obligatoria.")
    @Column(name = "rem_descripcion")
    private String descripcion;

    // Foreign Key - Relationships

    @NotNull(message = "La carrera es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false)
    private Carrera carrera;

}