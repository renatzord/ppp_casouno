package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suc_id")
    private Integer id;

    @Column(name = "suc_nombre")
    private String nombre;

    @Column(name = "suc_direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "epr_id")
    private Empresa empresa;

}
