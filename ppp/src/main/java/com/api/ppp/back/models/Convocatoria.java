package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "convocatoria", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cov_numero")
})
public class Convocatoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cov_id")
    private Integer id;

    @NotNull(message = "La fecha es obligatoria.")
    @Column(name = "cov_fecha_inicio")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaInicio;

    @NotNull(message = "La fecha es obligatoria.")
    @Column(name = "cov_fecha_fin")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaFin;

    @NotNull(message = "El número es obligatorio.")
    @Column(name = "cov_numero")
    private Integer numero;

    // Foreign Key - Relationships

    @NotNull(message = "La solicitud es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "sol_id")
    private SolicitudEmpresa solicitudEmpresa;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEstudiante> solicitudEstudiantes;

    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AccionConvoca> accionConvocas;

    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;

}
