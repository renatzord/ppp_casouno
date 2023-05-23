package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "aspecto")
public class Aspecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aps_id")
    private Integer id;

    @Column(name = "aps_detalle")
    @NotEmpty(message = "El detalle es obligatorio.")
    private String detalle;

    @Column(name = "aps_observaciones")
    @NotEmpty(message = "Las observaciones son obligatorias.")
    private String observaciones;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "aspecto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AspectoPractica> aspectoPracticas;

}
