package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

    @Id
    @Column(name = "cal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cal_tutor", nullable = false)
    @Min(value = 0)
    @Max(value = 1)
    private Integer tutor;

    @Column(name = "cal_a", nullable = false)
    @Min(value = 0)
    @Max(value = 20)
    private Integer a;

    @Column(name = "cal_b", nullable = false)
    @Min(value = 0)
    @Max(value = 20)
    private Integer b;

    @Column(name = "cal_c", nullable = false)
    @Min(value = 0)
    @Max(value = 20)
    private Integer c;

    @Column(name = "cal_d", nullable = false)
    @Min(value = 0)
    @Max(value = 20)
    private Integer d;

    @Column(name = "cal_e", nullable = false)
    @Min(value = 0)
    @Max(value = 20)
    private Integer e;

    @Column(name = "cal_total")
    private Integer total = 0;

    @Column(name = "cal_url")
    private String url;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id", nullable = false)
    @NotNull
    private Practica practica;
}

