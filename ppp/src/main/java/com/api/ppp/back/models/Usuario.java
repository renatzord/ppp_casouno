package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Integer id;

    @Column(name = "usu_rol")
    private Integer rol;

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

    // Foreign Key - Relationships

    @OneToOne(mappedBy = "usuario")
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario")
    private TutorInstituto tutorInstituto;

    @OneToOne(mappedBy = "usuario")
    private TutorEmpresarial tutorEmpresarial;

}
