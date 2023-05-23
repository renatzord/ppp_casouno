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

    @NotEmpty(message = "El asunto es obligatorio.")
    @Column(name = "vit_asunto")
    private String asunto;

    @NotNull(message = "La semana es obligatoria.")
    @Column(name = "vit_semana")
    private Integer semana;

    @Column(name = "vit_observacion")
    private String observacion;

    @Column(name = "vit_url",columnDefinition = "bytea")
    private byte[] url;

    // Foreign Key - Relationships

    @NotNull(message = "La práctica es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private Practica practica;

    // Bidirectional Relationships

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visita",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VisitaActividad> visitas;

}
