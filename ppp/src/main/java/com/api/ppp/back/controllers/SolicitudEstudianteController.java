package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Convocatoria;
import com.api.ppp.back.models.SolicitudEstudiante;
import com.api.ppp.back.services.SolicitudEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudEstudiante")
@CrossOrigin(origins="*")
public class SolicitudEstudianteController {

    @Autowired
    private SolicitudEstudianteService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<SolicitudEstudiante> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody SolicitudEstudiante entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    // To find one record and update it, specifically by a unique identifier (PK or ID)
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody SolicitudEstudiante entity) {
        Optional<SolicitudEstudiante> optional = service.findById(id);
        if(optional.isPresent()) {
            SolicitudEstudiante current = optional.get();
            current.setEstudiante(entity.getEstudiante());
            current.setConvocatoria(entity.getConvocatoria());
            current.setEstado(entity.getEstado());
            current.setFechaEnvio(entity.getFechaEnvio());
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

    //To find by convocatoria by MAC
    @GetMapping("/listarxconvocatoria")
    public List<SolicitudEstudiante> listarxConvocatoria(@RequestBody Convocatoria entity) {
        return service.solicitudesxConvocatoria(entity);
    }

    //Endopiont a peticion de brayan
    @GetMapping("/listarxconvocatoria2")
    public List<SolicitudEstudiante> listarxConvocatoria(@RequestParam Integer id) {
        Convocatoria entity = new Convocatoria();
        entity.setId(id);
        return service.solicitudesxConvocatoria(entity);
    }

}
