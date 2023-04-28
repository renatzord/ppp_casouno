package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "objetivo_materia")
public class ObjetivoMateria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obm_id")
    private Long id;

    @Column(name = "obm_descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "mat_id")
    private Materia materia;



}
