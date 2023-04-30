package com.api.ppp.back.models;

import jakarta.persistence.*;
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

    @Column(name = "cal_tutor")
    private Integer tutor;

    @Column(name = "cal_a")
    private Integer a;

    @Column(name = "cal_b")
    private Integer b;

    @Column(name = "cal_c")
    private Integer c;

    @Column(name = "cal_d")
    private Integer d;

    @Column(name = "cal_e")
    private Integer e;

    @Column(name = "cal_total")
    private Integer total;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id",referencedColumnName = "pra_id")
    private Practica practica;
}
