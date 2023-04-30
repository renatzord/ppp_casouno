package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
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

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "epr_id", referencedColumnName = "epr_id")
    private Empresa empresa;

}
