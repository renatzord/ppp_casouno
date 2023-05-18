package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.Sucursal;
import com.api.ppp.back.services.SucursalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sucursal")
@CrossOrigin(origins="*")
public class SucursalController {

    @Autowired
    private SucursalService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Sucursal> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Sucursal entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            // Verificar si el campo "nombre" está vacío
            if (entity.getNombre() == null || entity.getNombre().trim().isEmpty()) {
                errors.put("nombre", "El campo nombre es obligatorio");
            }

            // Verificar si el campo "direccion" está vacío
            if (entity.getDireccion() == null || entity.getDireccion().trim().isEmpty()) {
                errors.put("direccion", "El campo dirección es obligatorio");
            }

            // Verificar si el campo "empresa" es nulo
            if (entity.getEmpresa() == null) {
                errors.put("empresa", "El campo empresa es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody Sucursal entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            // Verificar si el campo "nombre" está vacío
            if (entity.getNombre() == null || entity.getNombre().trim().isEmpty()) {
                errors.put("nombre", "El campo nombre es obligatorio");
            }

            // Verificar si el campo "direccion" está vacío
            if (entity.getDireccion() == null || entity.getDireccion().trim().isEmpty()) {
                errors.put("direccion", "El campo dirección es obligatorio");
            }

            // Verificar si el campo "empresa" es nulo
            if (entity.getEmpresa() == null) {
                errors.put("empresa", "El campo empresa es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }
        Optional<Sucursal> optional = service.findById(id);
        if (optional.isPresent()) {
            Sucursal current = optional.get();
            current.setEmpresa(entity.getEmpresa());
            current.setNombre(entity.getNombre());
            current.setDireccion(entity.getDireccion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(current));
        }
        return ResponseEntity.notFound().build();
    }


    // To find one record and delete it, specifically by a unique identifier (PK or ID)
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarID(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
