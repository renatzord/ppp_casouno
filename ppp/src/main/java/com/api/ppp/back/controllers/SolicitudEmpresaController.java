package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.SolicitudEmpresa;
import com.api.ppp.back.services.SolicitudEmpresaService;
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
@RequestMapping("/solicitudEmpresa")
@CrossOrigin(origins="*")
public class SolicitudEmpresaController {

    @Autowired
    private SolicitudEmpresaService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<SolicitudEmpresa> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody SolicitudEmpresa entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "numPracticantes" es menor o igual a 0
            if (entity.getNumPracticantes() != null && entity.getNumPracticantes() <= 0) {
                errors.put("numPracticantes", "El número de practicantes debe ser mayor a 0");
            }

            // Verificar si el campo "numHoras" es null y establecerlo en 240 por defecto
            if (entity.getNumHoras() == null) {
                entity.setNumHoras(240);
            }

            // Verificar si el campo "fechaInicioTen" es null
            if (entity.getFechaInicioTen() == null) {
                errors.put("fechaInicioTen", "El campo fecha de inicio es obligatorio");
            }

            // Verificar si el campo "fechaMaxTen" es null
            if (entity.getFechaMaxTen() == null) {
                errors.put("fechaMaxTen", "El campo fecha máxima es obligatorio");
            }

            // Verificar si el campo "estado" es null y establecerlo en true por defecto
            if (entity.getEstado() == null) {
                entity.setEstado(0);
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody SolicitudEmpresa entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "numPracticantes" es menor o igual a 0
            if (entity.getNumPracticantes() != null && entity.getNumPracticantes() <= 0) {
                errors.put("numPracticantes", "El número de practicantes debe ser mayor a 0");
            }

            // Verificar si el campo "numHoras" es null y establecerlo en 240 por defecto
            if (entity.getNumHoras() == null) {
                entity.setNumHoras(240);
            }

            // Verificar si el campo "fechaInicioTen" es null
            if (entity.getFechaInicioTen() == null) {
                errors.put("fechaInicioTen", "El campo fecha de inicio es obligatorio");
            }

            // Verificar si el campo "fechaMaxTen" es null
            if (entity.getFechaMaxTen() == null) {
                errors.put("fechaMaxTen", "El campo fecha máxima es obligatorio");
            }

            // Verificar si el campo "estado" es null y establecerlo en true por defecto
            if (entity.getEstado() == null) {
                entity.setEstado(0);
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        Optional<SolicitudEmpresa> optional = service.findById(id);
        if (optional.isPresent()) {
            SolicitudEmpresa current = optional.get();
            current.setConvenio(entity.getConvenio());
            current.setNumPracticantes(entity.getNumPracticantes());
            current.setNumHoras(entity.getNumHoras());
            current.setFechaInicioTen(entity.getFechaInicioTen());
            current.setFechaMaxTen(entity.getFechaMaxTen());
            current.setEstado(entity.getEstado());
            current.setUrl(entity.getUrl());
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
