package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Visita;
import com.api.ppp.back.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/visita")
@CrossOrigin(origins="*")
public class VisitaController {

    @Autowired
    private VisitaService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Visita> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Visita entity) {
        Map<String, String> errors = new HashMap<>();

        if (entity.getAsunto() == null || entity.getAsunto().trim().isEmpty()) {
            errors.put("asunto", "El campo asunto es obligatorio");
        }
        if (entity.getSemana() == null) {
            errors.put("semana", "El campo semana es obligatorio");
        }
        if (entity.getObservacion() == null || entity.getObservacion().trim().isEmpty()) {
            errors.put("observacion", "El campo observacion es obligatorio");
        }

        if (errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
        } else {
            return ResponseEntity.badRequest().body(errors);
        }
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Visita entity) {
        Optional<Visita> optional = service.findById(id);
        if (optional.isPresent()) {
            Visita current = optional.get();
            current.setPractica(entity.getPractica());
            current.setAsunto(entity.getAsunto());
            current.setSemana(entity.getSemana());
            current.setObservacion(entity.getObservacion());
            current.setUrl(entity.getUrl());

            Map<String, String> errors = new HashMap<>();

            if (current.getAsunto() == null || current.getAsunto().trim().isEmpty()) {
                errors.put("asunto", "El campo asunto es obligatorio");
            }
            if (current.getSemana() == null) {
                errors.put("semana", "El campo semana es obligatorio");
            }
            if (current.getObservacion() == null || current.getObservacion().trim().isEmpty()) {
                errors.put("observacion", "El campo observacion es obligatorio");
            }

            if (errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(service.save(current));
            } else {
                return ResponseEntity.badRequest().body(errors);
            }
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
