package com.api.ppp.back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String titulo;
    private String telefono;
    private Boolean activo;

}
