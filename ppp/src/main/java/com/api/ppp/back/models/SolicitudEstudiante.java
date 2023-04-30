package com.api.ppp.back.models;

import jakarta.persistence.*;
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

    @Column(name = "ses_estado")
    private Boolean estado;

    @Column(name = "ses_fecha_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "est_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "cov_id", referencedColumnName = "cov_id")
    private Convocatoria convocatoria;

}
