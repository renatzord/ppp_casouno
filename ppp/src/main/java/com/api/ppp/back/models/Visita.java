package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "visita")
public class Visita implements Serializable {

    @Id
    @Column(name = "vit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vit_asunto")
    private String asunto;

    @Column(name = "vit_semana")
    private Integer semana;

    @Column(name = "vit_observacion")
    private String observacion;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private Practica practica;

    // Bidirectional Relationships

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visita",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VisitaActividad> visitas;

}
