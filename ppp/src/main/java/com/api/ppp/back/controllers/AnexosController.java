package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Anexos;
import com.api.ppp.back.services.AnexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/anexos")
public class AnexosController {

    @Autowired
    private AnexoService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Anexos> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Anexos entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    // To find one record and update it, specifically by a unique identifier (PK or ID)
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Anexos entity) {
        Optional<Anexos> optional = service.findById(id);
        if(optional.isPresent()) {
            Anexos current = optional.get();
            current.setUrl(entity.getUrl());
            current.setPractica(entity.getPractica());
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
