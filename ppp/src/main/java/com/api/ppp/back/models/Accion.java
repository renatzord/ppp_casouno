package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "accion")
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id")
    private Integer id;

    @Column(name = "acc_descripcion")
    private String descripcion;

    // Bidirectional Relationships

    @OneToMany(mappedBy = "accion")
    @JsonIgnore
    private List<AccionConvoca> accionConvocas;

}
