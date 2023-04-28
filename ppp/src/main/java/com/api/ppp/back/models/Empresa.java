package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "epr_id")
    private Long id;

    @Column(name = "epr_ruc")
    private String ruc;

    @Column(name = "epr_nombre")
    private String nombre;

    @Column(name = "epr_matriz")
    private String matriz;

    @Column(name = "epr_mision")
    private String mision;

    @Column(name = "epr_vision")
    private String vision;

    @Column(name = "epr_objetivo")
    private String objetivo;

    @Column(name = "epr_activo")
    private Boolean activo;

    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<Sucursal> sucursales;



}
