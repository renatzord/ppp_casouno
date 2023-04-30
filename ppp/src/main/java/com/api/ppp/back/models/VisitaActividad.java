package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "visita_actividad")
public class VisitaActividad implements Serializable {

    @Id
    @Column(name = "vac_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vac_actividad")
    private String actividad;

    @Column(name = "vac_observacion")
    private String observacion;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "vit_id",referencedColumnName = "vit_id")
    private Visita visita;

}
