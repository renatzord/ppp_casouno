package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Entity
@Data
@Table(name = "resultado")
public class Resultado implements Serializable {

    @Id
    @Column(name = "rel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    @NotNull(message = "El campo practica es obligatorio")
    private Practica practica;

    @ManyToOne
    @JoinColumn(name = "rem_id", referencedColumnName = "rem_id")
    @NotNull(message = "El campo resultadoMateria es obligatorio")
    private ResultadoMateria resultadoMateria;

    @ManyToOne
    @JoinColumn(name = "act_id", referencedColumnName = "act_id")
    @NotNull(message = "El campo actividad es obligatorio")
    private Actividad actividad;

}
