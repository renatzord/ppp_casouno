package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.Practica;
import com.api.ppp.back.services.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/practica")
public class PracticaController {

    @Autowired
    private PracticaService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Practica> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Practica entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    // To find one record and update it, specifically by a unique identifier (PK or ID)
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Practica entity) {
        Optional<Practica> optional = service.findById(id);
        if(optional.isPresent()) {
            Practica current = optional.get();
            current.setConvocatoria(entity.getConvocatoria());
            current.setEstudiante(entity.getEstudiante());
            current.setTutorEmpresarial(entity.getTutorEmpresarial());
            current.setTutorInstituto(entity.getTutorInstituto());
            current.setPeriodo(entity.getPeriodo());
            current.setNSemanas(entity.getNSemanas());
            current.setInicio(entity.getInicio());
            current.setFin(entity.getFin());
            current.setConcluciones(entity.getConcluciones());
            current.setDepartamento(entity.getDepartamento());
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
