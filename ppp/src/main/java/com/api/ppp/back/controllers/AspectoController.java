package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Aspecto;
import com.api.ppp.back.services.AspectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/aspecto")
@CrossOrigin(origins="*")
public class AspectoController {

    @Autowired
    private AspectoService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Aspecto> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Aspecto entity) {
        Map<String, String> errors = new HashMap<>();

        if (entity.getDetalle() == null || entity.getDetalle().trim().isEmpty()) {
            errors.put("detalle", "El campo detalle es obligatorio");
        }

        if (entity.getObservaciones() == null || entity.getObservaciones().trim().isEmpty()) {
            errors.put("observaciones", "El campo observaciones es obligatorio");
        }

        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Aspecto entity) {
        Optional<Aspecto> optional = service.findById(id);
        if (optional.isPresent()) {
            Aspecto current = optional.get();

            Map<String, String> errors = new HashMap<>();

            if (entity.getDetalle() == null || entity.getDetalle().trim().isEmpty()) {
                errors.put("detalle", "El campo detalle es obligatorio");
            }

            if (entity.getObservaciones() == null || entity.getObservaciones().trim().isEmpty()) {
                errors.put("observaciones", "El campo observaciones es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.badRequest().body(errors);
            }

            current.setDetalle(entity.getDetalle());
            current.setObservaciones(entity.getObservaciones());

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
