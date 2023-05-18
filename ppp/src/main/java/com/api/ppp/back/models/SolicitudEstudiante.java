package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "solicitud_estudiante")
public class SolicitudEstudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ses_id")
    private Integer id;

    @Column(name = "ses_estado", columnDefinition = "INTEGER DEFAULT 0")
    private Integer estado;

    @Column(name = "ses_fecha_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    @Column(name = "ses_url")
    private String url;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "est_id", nullable = false)
    @NotNull
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "cov_id", referencedColumnName = "cov_id", nullable = false)
    @NotNull
    private Convocatoria convocatoria;

    // Otros campos y relaciones

}

