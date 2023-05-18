package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.SemanaActividad;
import com.api.ppp.back.services.SemanaActividadService;
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
@RequestMapping("/semanaActividad")
@CrossOrigin(origins="*")
public class SemanaActividadController {

    @Autowired
    private SemanaActividadService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<SemanaActividad> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody SemanaActividad entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "dia" está vacío
            if (entity.getDia() == null) {
                errors.put("dia", "El campo día es obligatorio");
            }

            // Verificar si el campo "horaInicio" está vacío
            if (entity.getHoraInicio() == null) {
                errors.put("horaInicio", "El campo hora inicio es obligatorio");
            }

            // Verificar si el campo "horaFin" está vacío
            if (entity.getHoraFin() == null) {
                errors.put("horaFin", "El campo hora fin es obligatorio");
            }

            // Verificar si el campo "totalHoras" está vacío
            if (entity.getTotalHoras() == null) {
                errors.put("totalHoras", "El campo total horas es obligatorio");
            }

            // Verificar si el campo "actividad" está vacío
            if (entity.getActividad() == null || entity.getActividad().trim().isEmpty()) {
                errors.put("actividad", "El campo actividad es obligatorio");
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody SemanaActividad entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "dia" está vacío
            if (entity.getDia() == null) {
                errors.put("dia", "El campo día es obligatorio");
            }

            // Verificar si el campo "horaInicio" está vacío
            if (entity.getHoraInicio() == null) {
                errors.put("horaInicio", "El campo hora inicio es obligatorio");
            }

            // Verificar si el campo "horaFin" está vacío
            if (entity.getHoraFin() == null) {
                errors.put("horaFin", "El campo hora fin es obligatorio");
            }

            // Verificar si el campo "totalHoras" está vacío
            if (entity.getTotalHoras() == null) {
                errors.put("totalHoras", "El campo total horas es obligatorio");
            }

            // Verificar si el campo "actividad" está vacío
            if (entity.getActividad() == null || entity.getActividad().trim().isEmpty()) {
                errors.put("actividad", "El campo actividad es obligatorio");
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Optional<SemanaActividad> optional = service.findById(id);
        if (optional.isPresent()) {
            SemanaActividad current = optional.get();
            current.setPractica(entity.getPractica());
            current.setDia(entity.getDia());
            current.setHoraInicio(entity.getHoraInicio());
            current.setHoraFin(entity.getHoraFin());
            current.setTotalHoras(entity.getTotalHoras());
            current.setActividad(entity.getActividad());
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
