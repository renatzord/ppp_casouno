package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
@Table(name = "detalle_tarea")
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

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "tar_id",referencedColumnName = "tar_id")
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(name = "obm_id",referencedColumnName = "obm_id")
    private ObjetivoMateria objetivoMateria;
}
