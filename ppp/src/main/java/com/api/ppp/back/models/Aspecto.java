package com.api.ppp.back.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "aspectos")
public class Aspecto {

    @Id
    private Long id;
    private String detalle;
    private String observaciones;

}
