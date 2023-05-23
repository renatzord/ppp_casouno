package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    private Boolean respuesta = false;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    @NotNull(message = "La acción es obligatoria.")
    private Accion accion;

    @ManyToOne
    @JoinColumn(name = "cov_id", referencedColumnName = "cov_id")
    @NotNull(message = "La convocatoria es obligatorio.")
    private Convocatoria convocatoria;

}