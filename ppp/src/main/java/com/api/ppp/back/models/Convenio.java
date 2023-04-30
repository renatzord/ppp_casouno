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

    @Column(name = "con_numero")
    private Integer numero;

    @Column(name = "con_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "con_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "epr_id", referencedColumnName = "epr_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "con_firma_inst", referencedColumnName = "tin_id")
    private TutorInstituto firmaInst;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "convenio",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEmpresa> solicitudEmpresas;

}
