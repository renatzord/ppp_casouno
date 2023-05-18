package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Date dia;

    @Column(name = "sac_hora_inicio")
    @Temporal(TemporalType.TIME)
    @NotNull
    private LocalTime horaInicio;

    @Column(name = "sac_hora_fin")
    @Temporal(TemporalType.TIME)
    @NotNull
    private LocalTime horaFin;

    @Column(name = "sac_total_horas")
    @NotNull
    private Integer totalHoras;

    @Column(name = "sac_actividad")
    @NotEmpty
    private String actividad;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    @NotNull
    private Practica practica;

}
