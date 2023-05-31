package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "sol_num_horas", columnDefinition = "INTEGER DEFAULT 240")
    private Integer numHoras;

    @NotNull(message = "La fecha de inicio tentativa es obligatoria.")
    @Column(name = "sol_fecha_inicio_ten")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaInicioTen;

    @NotNull(message = "La fecha de fin tentativa es obligatoria.")
    @Column(name = "sol_max_ten")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaMaxTen;

    @Column(name = "sol_estado")
    private Integer estado = 1;

    @Column(name = "sol_url", columnDefinition = "bytea")
    private byte[] url;

    // Foreign Key - Relationships

    @NotNull(message = "El convenio es obligatorio")
    @ManyToOne
    @JoinColumn(name = "con_id", referencedColumnName = "con_id")
    private Convenio convenio;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "solicitudEmpresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Actividad> actividades;

    @OneToMany(mappedBy = "solicitudEmpresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Convocatoria> convocatorias;

}
