package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.Empresa;
import com.api.ppp.back.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/empresa")
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
    public ResponseEntity<?> crear(@RequestBody Empresa entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    // To find one record and update it, specifically by a unique identifier (PK or ID)
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Empresa entity) {
        Optional<Empresa> optional = service.findById(id);
        if(optional.isPresent()) {
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
