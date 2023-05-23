package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "resultado")
public class Resultado implements Serializable {

    @Id
    @Column(name = "rel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign Key - Relationships

    @NotNull(message = "La practica es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private Practica practica;

    @NotNull(message = "El resultadoMateria es obligatorio.")
    @ManyToOne
    @JoinColumn(name = "rem_id", referencedColumnName = "rem_id")
    private ResultadoMateria resultadoMateria;

    @NotNull(message = "La actividad es obligatoria")
    @ManyToOne
    @JoinColumn(name = "act_id", referencedColumnName = "act_id")
    private Actividad actividad;

}
