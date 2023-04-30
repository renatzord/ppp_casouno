package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "accion_convoca")
public class AccionConvoca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acv_id")
    private Integer id;

    @Column(name = "acv_respuesta")
    private Boolean respuesta;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    private Accion accion;

    @ManyToOne
    @JoinColumn(name = "cov_id", referencedColumnName = "cov_id")
    private Convocatoria convocatoria;

}
