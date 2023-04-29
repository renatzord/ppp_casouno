package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Data
public class DetalleTarea implements Serializable {

    @Id
    @Column(name = "dta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dta_descripcion")
    private String descripcion;

    @Column(name = "dta_semana")
    private String semana;

    @Column(name = "dta_horas")
    private Integer horas;

    @ManyToOne
    @JoinColumn(name = "tar_id",referencedColumnName = "tar_id")
    private Tarea tarea;

    /* @ManyToOne
    @JoinColumn(name = "obm_id",referencedColumnName = "obm_id")
    private ObjetoMateria tarea;*/
}
