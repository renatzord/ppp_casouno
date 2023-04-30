package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "semana_actividad")
public class SemanaActividad implements Serializable {

    @Id
    @Column(name = "sac_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sac_dia")
    @Temporal(TemporalType.DATE)
    private Date dia;

    @Column(name = "sac_hora_inicio")
    @Temporal(TemporalType.TIME)
    private LocalTime horaInicio;

    @Column(name = "sac_hora_fin")
    @Temporal(TemporalType.TIME)
    private LocalTime horaFin;

    @Column(name = "sac_total_horas")
    private Integer totalHoras;

    @Column(name = "sac_actividad")
    private String actividad;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id",referencedColumnName = "pra_id")
    private Practica practica;

}
