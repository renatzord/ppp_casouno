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
@Table(name = "carrera")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "id_carrera")
    private Integer idCarrera;

    @Column(name = "car_nombre")
    private String nombre;

    @Column(name = "car_activo")
    private Boolean activo;

    @OneToMany(mappedBy = "carrera")
    @JsonIgnore
    private List<ResultadoMateria> resultadoMaterias;

    @OneToMany(mappedBy = "carrera")
    @JsonIgnore
    private List<Convenio> convenios;

}
