package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "convenio")
public class Convenio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long id;

    @Column(name = "con_numero")
    private Integer numero;

    @Column(name = "con_fecha_inicio")
    private Date fechaInicio;

    @Column(name = "con_fecha_fin")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "epr_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Carrera carrera;

    @OneToMany(mappedBy = "convenio")
    @JsonIgnore
    private List<SolicitudEmpresa> solicitudEmpresas;





}
