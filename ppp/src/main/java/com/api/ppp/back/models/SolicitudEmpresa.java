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
@Table(name = "solicitud_empresa")
public class SolicitudEmpresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sol_id")
    private Long id;

    @Column(name = "sol_num_practicas")
    private Integer numPracticantes;

    @Column(name = "sol_num_horas")
    private Integer numHoras;

    @Column(name = "sol_fecha_inicio_ten")
    private Date fechaInicioTen;

    @Column(name = "sol_max_ten")
    private Date fechaMaxTen;

    @Column(name = "sol_estado")
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "con_id")
    private Convenio convenio;



}
