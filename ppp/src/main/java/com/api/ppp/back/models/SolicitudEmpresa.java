package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "solicitud_empresa")
public class SolicitudEmpresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sol_id")
    private Integer id;

    @Column(name = "sol_num_practicas")
    private Integer numPracticantes;

    @Column(name = "sol_num_horas")
    private Integer numHoras;

    @Column(name = "sol_fecha_inicio_ten")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioTen;

    @Column(name = "sol_max_ten")
    @Temporal(TemporalType.DATE)
    private Date fechaMaxTen;

    @Column(name = "sol_estado")
    private Integer estado;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "con_id", referencedColumnName = "con_id")
    private Convenio convenio;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "solicitudEmpresa",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Actividad> actividades;

    @OneToMany(mappedBy = "solicitudEmpresa",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Convocatoria> convocatorias;

}
