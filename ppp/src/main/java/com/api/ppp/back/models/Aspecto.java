package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String detalle;

    @Column(name = "aps_observaciones")
    private String observaciones;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "aspecto",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AspectoPractica> aspectoPracticas;

}
