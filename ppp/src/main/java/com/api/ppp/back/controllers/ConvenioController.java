package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.Convenio;
import com.api.ppp.back.services.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/convenio")
@CrossOrigin(origins="*")
public class ConvenioController {

    @Autowired
    private ConvenioService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Convenio> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Convenio entity) {
        // Verificar si el número del convenio ya existe
        if (service.existsByNumero(entity.getNumero())) {
            Map<String, String> error = new HashMap<>();
            error.put("numero", "El número de convenio ya existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        // Verificar si los campos obligatorios están presentes
        if (entity.getNumero() == null || entity.getFechaInicio() == null || entity.getFechaFin() == null) {
            Map<String, String> error = new HashMap<>();
            if (entity.getNumero() == null) {
                error.put("numero", "El número de convenio es obligatorio");
            }
            if (entity.getFechaInicio() == null) {
                error.put("fechaInicio", "La fecha de inicio es obligatoria");
            }
            if (entity.getFechaFin() == null) {
                error.put("fechaFin", "La fecha de fin es obligatoria");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Convenio entity) {
        Optional<Convenio> optional = service.findById(id);
        if (optional.isPresent()) {
            Convenio current = optional.get();

            // Verificar si el número del convenio ya existe
            if (!current.getNumero().equals(entity.getNumero()) && service.existsByNumero(entity.getNumero())) {
                Map<String, String> error = new HashMap<>();
                error.put("numero", "El número de convenio ya existe");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }

            // Verificar si los campos obligatorios están presentes
            if (entity.getNumero() == null || entity.getFechaInicio() == null || entity.getFechaFin() == null) {
                Map<String, String> error = new HashMap<>();
                if (entity.getNumero() == null) {
                    error.put("numero", "El número de convenio es obligatorio");
                }
                if (entity.getFechaInicio() == null) {
                    error.put("fechaInicio", "La fecha de inicio es obligatoria");
                }
                if (entity.getFechaFin() == null) {
                    error.put("fechaFin", "La fecha de fin es obligatoria");
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }

            current.setCarrera(entity.getCarrera());
            current.setEmpresa(entity.getEmpresa());
            current.setNumero(entity.getNumero());
            current.setFirmaInst(entity.getFirmaInst());
            current.setFechaFin(entity.getFechaFin());
            current.setFechaInicio(entity.getFechaInicio());
            current.setSolicitudEmpresas(entity.getSolicitudEmpresas());
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
