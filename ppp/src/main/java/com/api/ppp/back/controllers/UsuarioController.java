package com.api.ppp.back.controllers;

import com.api.ppp.back.daos.AuthorityRepository;
import com.api.ppp.back.models.Usuario;
import com.api.ppp.back.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private AuthorityRepository authorityRepository;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Usuario> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
   @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "cedula" está vacío
            if (entity.getCedula() == null || entity.getCedula().trim().isEmpty()) {
                errors.put("cedula", "El campo cédula es obligatorio");
            }

            // Verificar si el campo "nombre" está vacío
            if (entity.getNombre() == null || entity.getNombre().trim().isEmpty()) {
                errors.put("nombre", "El campo nombre es obligatorio");
            }

            // Verificar si el campo "apellido" está vacío
            if (entity.getApellido() == null || entity.getApellido().trim().isEmpty()) {
                errors.put("apellido", "El campo apellido es obligatorio");
            }

            // Verificar si el campo "correo" está vacío
            if (entity.getCorreo() == null || entity.getCorreo().trim().isEmpty()) {
                errors.put("correo", "El campo correo es obligatorio");
            }

            // Verificar si el campo "telefono" está vacío
            if (entity.getTelefono() == null || entity.getTelefono().trim().isEmpty()) {
                errors.put("telefono", "El campo teléfono es obligatorio");
            }

            // Verificar si el campo "titulo" está vacío
            if (entity.getTitulo() == null || entity.getTitulo().trim().isEmpty()) {
                errors.put("titulo", "El campo título es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody Usuario entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "cedula" está vacío
            if (entity.getCedula() == null || entity.getCedula().trim().isEmpty()) {
                errors.put("cedula", "El campo cédula es obligatorio");
            }

            // Verificar si el campo "nombre" está vacío
            if (entity.getNombre() == null || entity.getNombre().trim().isEmpty()) {
                errors.put("nombre", "El campo nombre es obligatorio");
            }

            // Verificar si el campo "apellido" está vacío
            if (entity.getApellido() == null || entity.getApellido().trim().isEmpty()) {
                errors.put("apellido", "El campo apellido es obligatorio");
            }

            // Verificar si el campo "correo" está vacío
            if (entity.getCorreo() == null || entity.getCorreo().trim().isEmpty()) {
                errors.put("correo", "El campo correo es obligatorio");
            }

            // Verificar si el campo "telefono" está vacío
            if (entity.getTelefono() == null || entity.getTelefono().trim().isEmpty()) {
                errors.put("telefono", "El campo teléfono es obligatorio");
            }

            // Verificar si el campo "titulo" está vacío
            if (entity.getTitulo() == null || entity.getTitulo().trim().isEmpty()) {
                errors.put("titulo", "El campo título es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        Optional<Usuario> optional = service.findById(id);
        if (optional.isPresent()) {
            Usuario current = optional.get();
            current.setCedula(entity.getCedula());
            current.setNombre(entity.getNombre());
            current.setApellido(entity.getApellido());
            current.setCorreo(entity.getCorreo());
            current.setTelefono(entity.getTelefono());
            current.setTitulo(entity.getTitulo());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(current));
        }

        return ResponseEntity.notFound().build();
    }





    // To list users by thier role
    @GetMapping("/listar/rol")
    public ResponseEntity<?> listarRol(String rol) {
        return ResponseEntity.ok().body(authorityRepository.findByName(rol));
    }

}
