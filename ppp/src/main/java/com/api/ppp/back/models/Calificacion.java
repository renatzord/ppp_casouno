package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

    @Id
    @Column(name = "cal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cal_tutor")
    @NotNull(message = "El tutor es obligatorio.")
    @Min(value = 0, message = "Tutor solo puede ser 0 y 1.") @Max(value = 1, message = "Tutor solo puede ser 0 y 1.")
    private Integer tutor;

    @Column(name = "cal_a", nullable = false)
    @NotNull(message = "A es obligatorio.")
    @Min(value = 0, message = "A solo puede tener valores del 0 y 20.") @Max(value = 20, message = "A solo puede tener valores del 0 y 20.")
    private Integer a;

    @Column(name = "cal_b")
    @NotNull(message = "B es obligatorio.")
    @Min(value = 0, message = "B solo puede tener valores del 0 y 20.") @Max(value = 20, message = "B solo puede tener valores del 0 y 20.")
    private Integer b;

    @Column(name = "cal_c", nullable = false)
    @NotNull(message = "C es obligatorio.")
    @Min(value = 0, message = "C solo puede tener valores del 0 y 20.") @Max(value = 20, message = "C solo puede tener valores del 0 y 20.")
    private Integer c;

    @Column(name = "cal_d")
    @NotNull(message = "D es obligatorio.")
    @Min(value = 0, message = "D solo puede tener valores del 0 y 20.") @Max(value = 20, message = "D solo puede tener valores del 0 y 20.")
    private Integer d;

    @Column(name = "cal_e")
    @NotNull(message = "E es obligatorio.")
    @Min(value = 0, message = "E solo puede tener valores del 0 y 20.") @Max(value = 20, message = "E solo puede tener valores del 0 y 20.")
    private Integer e;

    @Column(name = "cal_total")
    private Integer total = 0;

    @Column(name = "cal_url", columnDefinition = "bytea")
    private byte[] url;

    // Foreign Key - Relationships

    @NotNull(message = "La práctica es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id", nullable = false)
    private Practica practica;

}
