package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tutor_instituto")
public class TutorInstituto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tin_id")
    private Integer id;


    @Column(name = "tin_rol")
    private String rol;

    // Relationships

    @Column(name = "tin_docente_id")
    private String docente_id;

    @OneToOne
    @JoinColumn(name = "tin_usu_id")
    private Usuario usuario;




}
