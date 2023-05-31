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
@Table(name = "convenio", uniqueConstraints = {
        @UniqueConstraint(columnNames = "con_numero")
})
public class Convenio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Integer id;

    @NotNull(message = "Em número es obligatorio.")
    @Column(name = "con_numero")
    private Integer numero;

    @NotNull(message = "La fecha es obligatoria.")
    @Column(name = "con_fecha_inicio")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @NotNull(message = "La fecha es obligatoria.")
    @Column(name = "con_fecha_fin")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    //@Lob
    @Column(name = "con_url" ,columnDefinition = "bytea")
    private byte[] url;

    // Foreign Key - Relationships

    @NotNull(message = "La empresa es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "epr_id", referencedColumnName = "epr_id", nullable = false)
    private Empresa empresa;

    @NotNull(message = "La carrera es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false)
    private Carrera carrera;

    //@NotNull(message = "La firma/RESPP es obligatoria.")
    @ManyToOne
    @JoinColumn(name = "con_firma_inst", referencedColumnName = "tin_id")
    private TutorInstituto firmaInst;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SolicitudEmpresa> solicitudEmpresas;

}
