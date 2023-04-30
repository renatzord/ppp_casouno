package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Entity
@Data
@Table(name = "tarea")
public class Tarea implements Serializable {

    @Id
    @Column(name = "tar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tar_descripcion")
    private String descripcion;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "act_id",referencedColumnName = "act_id")
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "mat_id",referencedColumnName = "mat_id")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "rel_id", referencedColumnName = "rel_id")
    private Resultado resultado;

    // Bidirectional Relationships

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarea", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetalleTarea> detalleTareas;

}
