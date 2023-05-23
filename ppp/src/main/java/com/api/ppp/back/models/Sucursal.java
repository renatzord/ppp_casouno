package com.api.ppp.back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty(message = "El nombre es obligatorio.")
    @Column(name = "suc_nombre")
    private String nombre;

    @NotEmpty(message = "La dirección es obligatoria.")
    @Column(name = "suc_direccion")
    private String direccion;

    // Foreign Key - Relationships

    @NotNull(message = "La empresa es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "epr_id", referencedColumnName = "epr_id")
    private Empresa empresa;

}
