package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "solicitud_estudiante")
public class SolicitudEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ses_id")
    private Integer id;

    @Column(name = "ses_estado")
    private Boolean estado;

    @Column(name = "ses_fecha_envio")
    private Date fechaEnvio;

    // Foreign Key - Relationships

    @OneToOne
    @JoinColumn(name = "ses_est_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "ses_cov_id")
    private Convocatoria convocatoria;

    // Bidirectional Relationships

}
