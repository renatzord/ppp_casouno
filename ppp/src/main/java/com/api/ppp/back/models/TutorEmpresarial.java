package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tutor_empresarial")
public class TutorEmpresarial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tem_id")
    private Integer id;

    @Column(name = "tem_rol")
    private String rol;

    @Column(name = "tem_cargo")
    private String cargo;

    // Relationships

    @OneToOne
    @JoinColumn(name = "tem_usu_id")
    private Usuario usuario;

    //@ManyToOne
    //@JoinColumn(name = "tem_emp_id")
    //private Empresa empresa;


}
