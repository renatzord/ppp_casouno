package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "notificacion")
public class Notificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "not_id")
    private Integer id;

    @Column(name = "not_tipo")
    private Integer tipo;

    // Foreign Key - Relationships

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_id_tutor", referencedColumnName = "usu_id")
    private Usuario usuarioTutor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_id_estudiante", referencedColumnName = "usu_id")
    private Usuario usuarioEstudiante;


}
