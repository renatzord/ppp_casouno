package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "epr_id")
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "\\d{10}001")
    @Column(name = "epr_ruc", unique = true)
    private String ruc;

    @NotEmpty
    @Column(name = "epr_nombre")
    private String nombre;

    @NotEmpty
    @Column(name = "epr_matriz")
    private String matriz;

    @NotEmpty
    @Column(name = "epr_mision")
    private String mision;

    @NotEmpty
    @Column(name = "epr_vision")
    private String vision;

    @Column(name = "epr_objetivo")
    private String objetivo;

    @Column(name = "epr_activo")
    private Boolean activo = true;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Sucursal> sucursales;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TutorEmpresarial> empleados;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Convenio> convenios;

}
