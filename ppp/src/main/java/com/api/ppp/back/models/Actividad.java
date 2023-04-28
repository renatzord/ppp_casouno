package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Long id;

    @Column(name = "act_descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "sol_id")
    private SolicitudEmpresa solicitudEmpresa;




}
