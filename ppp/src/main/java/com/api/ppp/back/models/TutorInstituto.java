package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tutor_instituto")
public class TutorInstituto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tin_id")
    private Integer id;

    @Column(name = "tin_docente_id")
    private String idDocente;

    @Column(name = "tin_rol")
    private Integer rol;

    // Foreign Key - Relationships

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    private Usuario usuario;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "tutorInstituto",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;

    @OneToMany(mappedBy = "firmaInst",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Convenio> convenios;


}
