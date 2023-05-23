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
@Table(name = "empresa", uniqueConstraints = {
        @UniqueConstraint(columnNames = "epr_ruc")
})
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "epr_id")
    private Integer id;

    @NotEmpty(message = "El RUC es obligatorio.")
    @Pattern(regexp = "\\d{10}001", message = "El RUC no tiene el formato requerido")
    @Column(name = "epr_ruc")
    private String ruc;

    @NotEmpty(message = "El nombre es obligatorio.")
    @Column(name = "epr_nombre")
    private String nombre;

    @NotEmpty(message = "La matriz es obligatoria.")
    @Column(name = "epr_matriz")
    private String matriz;

    @NotEmpty(message = "La misión es obligatoria.")
    @Column(name = "epr_mision")
    private String mision;

    @NotEmpty(message = "La visión es obligatoria.")
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
