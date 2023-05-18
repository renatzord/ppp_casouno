package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "convenio")
public class Convenio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Integer id;

    @Column(name = "con_numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "con_fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "con_fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @Column(name = "con_url")
    private String url;

    // Foreign Key - Relationships

    @ManyToOne(optional = false)
    @JoinColumn(name = "epr_id", referencedColumnName = "epr_id", nullable = false)
    private Empresa empresa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false)
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "con_firma_inst", referencedColumnName = "tin_id")
    private TutorInstituto firmaInst;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEmpresa> solicitudEmpresas;
}

