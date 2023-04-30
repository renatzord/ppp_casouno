package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "anexos")
public class Anexos implements Serializable {

    @Id
    @Column(name = "ane_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ane_url")
    private String url;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private Practica practica;

}
