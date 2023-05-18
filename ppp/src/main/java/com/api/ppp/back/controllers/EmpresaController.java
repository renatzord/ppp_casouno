package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.Empresa;
import com.api.ppp.back.services.EmpresaService;
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
@RequestMapping("/empresa")
@CrossOrigin(origins="*")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Empresa> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Empresa entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "ruc" está vacío
            if (entity.getRuc() == null || entity.getRuc().trim().isEmpty()) {
                errors.put("ruc", "El campo RUC es obligatorio");
            }

            // Verificar si el campo "nombre" está vacío
            if (entity.getNombre() == null || entity.getNombre().trim().isEmpty()) {
                errors.put("nombre", "El campo nombre es obligatorio");
            }

            // Verificar si el campo "matriz" está vacío
            if (entity.getMatriz() == null || entity.getMatriz().trim().isEmpty()) {
                errors.put("matriz", "El campo matriz es obligatorio");
            }

            // Verificar si el campo "mision" está vacío
            if (entity.getMision() == null || entity.getMision().trim().isEmpty()) {
                errors.put("mision", "El campo misión es obligatorio");
            }

            // Verificar si el campo "vision" está vacío
            if (entity.getVision() == null || entity.getVision().trim().isEmpty()) {
                errors.put("vision", "El campo visión es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody Empresa entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "ruc" está vacío
            if (entity.getRuc() == null || entity.getRuc().trim().isEmpty()) {
                errors.put("ruc", "El campo RUC es obligatorio");
            }

            // Verificar si el campo "nombre" está vacío
            if (entity.getNombre() == null || entity.getNombre().trim().isEmpty()) {
                errors.put("nombre", "El campo nombre es obligatorio");
            }

            // Verificar si el campo "matriz" está vacío
            if (entity.getMatriz() == null || entity.getMatriz().trim().isEmpty()) {
                errors.put("matriz", "El campo matriz es obligatorio");
            }

            // Verificar si el campo "mision" está vacío
            if (entity.getMision() == null || entity.getMision().trim().isEmpty()) {
                errors.put("mision", "El campo misión es obligatorio");
            }

            // Verificar si el campo "vision" está vacío
            if (entity.getVision() == null || entity.getVision().trim().isEmpty()) {
                errors.put("vision", "El campo visión es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        Optional<Empresa> optional = service.findById(id);
        if (optional.isPresent()) {
            Empresa current = optional.get();
            current.setRuc(entity.getRuc());
            current.setNombre(entity.getNombre());
            current.setMatriz(entity.getMatriz());
            current.setMision(entity.getMision());
            current.setVision(entity.getVision());
            current.setObjetivo(entity.getObjetivo());
            current.setActivo(entity.getActivo());
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
