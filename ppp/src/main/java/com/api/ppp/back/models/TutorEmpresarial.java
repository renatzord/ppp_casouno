package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tutor_empresarial")
public class TutorEmpresarial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tem_id")
    private Integer id;

    @Column(name = "tem_rol")
    private Integer rol;

    @Column(name = "tem_cargo")
    private String cargo;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "epr_id", referencedColumnName = "epr_id")
    private Empresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    private Usuario usuario;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "tutorEmpresarial",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;

}
