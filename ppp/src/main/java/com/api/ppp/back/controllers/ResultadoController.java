package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Materia;
import com.api.ppp.back.models.Resultado;
import com.api.ppp.back.services.ResultadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/resultado")
@CrossOrigin(origins="*")
public class ResultadoController {

    @Autowired
    private ResultadoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Resultado> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Resultado entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            // Verificar si el campo "practica" está vacío
            if (entity.getPractica() == null) {
                errors.put("practica", "El campo practica es obligatorio");
            }

            // Verificar si el campo "resultadoMateria" está vacío
            if (entity.getResultadoMateria() == null) {
                errors.put("resultadoMateria", "El campo resultadoMateria es obligatorio");
            }

            // Verificar si el campo "actividad" está vacío
            if (entity.getActividad() == null) {
                errors.put("actividad", "El campo actividad es obligatorio");
            }

            // Agregar otros mensajes de validación si es necesario

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody Resultado entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            // Verificar si el campo "practica" está vacío
            if (entity.getPractica() == null) {
                errors.put("practica", "El campo practica es obligatorio");
            }

            // Verificar si el campo "resultadoMateria" está vacío
            if (entity.getResultadoMateria() == null) {
                errors.put("resultadoMateria", "El campo resultadoMateria es obligatorio");
            }

            // Verificar si el campo "actividad" está vacío
            if (entity.getActividad() == null) {
                errors.put("actividad", "El campo actividad es obligatorio");
            }

            // Agregar otros mensajes de validación si es necesario

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        Optional<Resultado> optional = service.findById(id);
        if (optional.isPresent()) {
            Resultado current = optional.get();
            current.setId(entity.getId());
            current.setPractica(entity.getPractica());
            current.setActividad(entity.getActividad());
            current.setResultadoMateria(entity.getResultadoMateria());
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
