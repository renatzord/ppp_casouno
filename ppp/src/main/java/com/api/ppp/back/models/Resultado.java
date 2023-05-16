package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Entity
@Data
@Table(name = "resultado")
public class Resultado implements Serializable {

    @Id
    @Column(name = "rel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id",referencedColumnName = "pra_id")
    private Practica practica;

    @ManyToOne
    @JoinColumn(name = "rem_id",referencedColumnName = "rem_id")
    private ResultadoMateria resultadoMateria;

    @ManyToOne
    @JoinColumn(name = "act_id",referencedColumnName = "act_id")
    private Actividad actividad;

}
