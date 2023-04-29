package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "materia")
public class Materia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mat_id")
    private Integer id;

    @Column(name = "id_materia")
    private Integer idMateria;

    @Column(name = "mat_nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Carrera carrera;

    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    private List<ObjetivoMateria> objetivoMaterias;




}
