package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;

    @Column(name = "id_carrera")
    private Integer idCarrera;

    @Column(name = "car_nombre")
    private String nombre;

    @Column(name = "car_activo")
    private Boolean activo;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "carrera",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ResultadoMateria> resultadoMaterias;

    @OneToMany(mappedBy = "carrera",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Convenio> convenios;

}
