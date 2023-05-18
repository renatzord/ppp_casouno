package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty
    @Column(name = "vit_asunto")
    private String asunto;

    @NotNull
    @Column(name = "vit_semana")
    private Integer semana;

    @NotEmpty
    @Column(name = "vit_observacion")
    private String observacion;

    @Column(name = "vit_url")
    private String url;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id", nullable = false)
    private Practica practica;

    // Bidirectional Relationships

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visita", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VisitaActividad> visitas;

}

