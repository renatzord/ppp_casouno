package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @NotNull(message = "La fecha es obligatoria.")
    @Column(name = "sac_dia")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dia;

    @NotNull(message = "La hora de inicio es obligatoria.")
    @Column(name = "sac_hora_inicio")
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin es obligatoria.")
    @Column(name = "sac_hora_fin")
    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaFin;

    @NotNull(message = "El número de horas es obligatorio")
    @Column(name = "sac_total_horas")
    private Integer totalHoras;

    @NotEmpty(message = "La actividad es obligatoria.")
    @Column(name = "sac_actividad")
    private String actividad;

    // Foreign Key - Relationships

    @NotNull(message = "La práctica es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private Practica practica;

}
