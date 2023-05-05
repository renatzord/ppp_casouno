package com.api.ppp.back.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    private String nombre;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "usu_id")
    private Usuario usuario;

}
