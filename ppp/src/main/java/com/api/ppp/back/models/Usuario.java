package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @NotEmpty
    @Pattern(regexp = "\\d{10}")
    @Column(name = "usu_cedula", unique = true)
    private String cedula;

    @NotEmpty
    @Pattern(regexp = "[A-Za-záéíóúñÁÉÍÓÚÑ\\s]+")
    @Column(name = "usu_nombre")
    private String nombre;

    @NotEmpty
    @Pattern(regexp = "[A-Za-záéíóúñÁÉÍÓÚÑ\\s]+")
    @Column(name = "usu_apellido")
    private String apellido;

    @NotEmpty
    @Email
    @Column(name = "usu_correo")
    private String correo;

    @NotEmpty
    @Pattern(regexp = "[A-Za-záéíóúñÁÉÍÓÚÑ\\s]+")
    @Column(name = "usu_titulo")
    private String titulo;

    @NotEmpty
    @Pattern(regexp = "\\d+")
    @Column(name = "usu_telefono")
    private String telefono;

    @Column(name = "usu_activo")
    private Boolean activo = true;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // Bidirectional Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<Authority> authorities;

}
