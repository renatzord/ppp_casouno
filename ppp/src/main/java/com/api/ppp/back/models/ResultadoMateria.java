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
@Table(name = "resultado_materia")
public class ResultadoMateria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rem_id")
    private Long id;

    @Column(name = "rem_descripcion")
    private String descripcion;

    @ManyToOne()
    @JoinColumn(name = "car_id")
    private Carrera carrera;

}
