package com.api.ppp.back.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "usuario", uniqueConstraints = {
        @UniqueConstraint(columnNames = "usu_correo"),
        @UniqueConstraint(columnNames = "usu_cedula")
})
public class Usuario implements Serializable {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name = "native", strategy = "native")
    @Column(name = "usu_id")
    private Integer id;

    @NotEmpty(message = "Campo obligatorio.")
    @Pattern(regexp = "^\\d{10}$", message = "La cédula debe contener exactamente 10 dígitos.")
    @Column(name = "usu_cedula")
    private String cedula;

    @NotEmpty(message = "Campo obligatorio.")
    @Column(name = "usu_nombre")
    private String nombre;

    @NotEmpty(message = "Campo obligatorio.")
    @Column(name = "usu_apellido")
    private String apellido;

    @Email(message = "No corresponde a un Email.")
    @Column(name = "usu_correo")
    private String correo;

    @Column(name = "usu_titulo")
    private String titulo;

    @Pattern(regexp = "\\d+", message = "El teléfono debe contar solo con números")
    @Column(name = "usu_telefono")
    private String telefono;

    @Column(name = "usu_activo")
    private Boolean activo = true;

    @NotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // Bidirectional Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioTutor", fetch = FetchType.LAZY)
    private List<Notificacion> notificaciones_tutores;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioEstudiante", fetch = FetchType.LAZY)
    private List<Notificacion> notificaciones_estudiante;

}
