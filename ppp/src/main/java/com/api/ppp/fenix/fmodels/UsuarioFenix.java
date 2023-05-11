package com.api.ppp.fenix.fmodels;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario_ppp")
public class UsuarioFenix implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer alumno_docenteId;

    @Column(name = "identificacion")
    private String cedula;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ciclo")
    private Integer ciclo;

    @Column(name = "carrera")
    private Integer carreraId;

    @Column(name = "periodo")
    private String periodo;

    @Column(name = "tipo")
    private Integer tipo;
}
