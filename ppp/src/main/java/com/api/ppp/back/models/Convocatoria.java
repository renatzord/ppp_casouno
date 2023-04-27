package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "convovatoria")
public class Convocatoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cov_id")
    private Integer id;

    @Column(name = "cov_fecha_inicio")
    private Date fechaInicio;

    @Column(name = "cov_fecha_fin")
    private Date fechaFin;

    @Column(name = "cov_numero")
    private Integer numero;

    // Foreign Key - Relationships

    /*@ManyToOne
    @JoinColumn(name = "cov_sol_id")
    private SolicitudEmpresa solicitudEmpresa;*/

    // Bidirectional Relationships

    @OneToMany(mappedBy = "convocatoria")
    @JsonIgnore
    private List<SolicitudEstudiante> solicitudEstudiante;


}
