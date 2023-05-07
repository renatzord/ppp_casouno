package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Integer id;

    @Column(name = "usu_cedula")
    private String cedula;

    @Column(name = "usu_nombre")
    private String nombre;

    @Column(name = "usu_apellido")
    private String apellido;

    @Column(name = "usu_correo")
    private String correo;

    @Column(name = "usu_titulo")
    private String titulo;

    @Column(name = "usu_telefono")
    private String telefono;

    @Column(name = "usu_activo")
    private Boolean activo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // Bidirectional Relationships

    @JsonIgnore
    @OneToMany(mappedBy="usuario", fetch=FetchType.EAGER)
    private Set<Authority> authorities;

}
