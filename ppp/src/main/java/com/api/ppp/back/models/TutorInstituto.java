package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tutor_instituto", uniqueConstraints = {
        @UniqueConstraint(columnNames = "tin_docente_id"),
        @UniqueConstraint(columnNames = "usu_id")
})
public class TutorInstituto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tin_id")
    private Integer id;

    @NotNull(message = "Error en datos provenientes de Fenix")
    @Column(name = "tin_docente_id")
    private Integer idDocente;

    // Foreign Key - Relationships

    @NotNull(message = "El usuario es obligatorio.")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    private Usuario usuario;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "tutorInstituto",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Practica> practicas;

    @OneToMany(mappedBy = "firmaInst",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Convenio> convenios;

}
