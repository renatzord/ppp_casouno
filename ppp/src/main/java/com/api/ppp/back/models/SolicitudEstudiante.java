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

    @Column(name = "ses_estado")
    private Integer estado;

    @NotNull(message = "La fecha de envio es obligatoria.")
    @Column(name = "ses_fecha_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;

    @Column(name = "ses_url",columnDefinition = "bytea")
    private byte[] url;

    // Foreign Key - Relationships

    @NotNull(message = "El estudiante es obligatorio.")
    @ManyToOne
    @JoinColumn(name = "est_id")
    private Estudiante estudiante;

    @NotNull(message = "La convocatoria es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "cov_id", referencedColumnName = "cov_id")
    private Convocatoria convocatoria;

}
