package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "accion_convoca")
public class AccionConvoca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acv_id")
    private Integer id;

    @Column(name = "acv_respuesta")
    private Boolean respuesta;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "acv_acc_id")
    private Accion accion;

    @ManyToOne
    @JoinColumn(name = "acv_cov_id")
    private Convocatoria convocatoria;

    // Bidirectional Relationships

}
