package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
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

}
