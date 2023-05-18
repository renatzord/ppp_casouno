package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Actividad;
import com.api.ppp.back.models.SolicitudEmpresa;
import com.api.ppp.back.services.ActividadService;
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
@RequestMapping("/actividad")
@CrossOrigin(origins="*")
public class ActividadController {

    @Autowired
    private ActividadService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Actividad> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Actividad entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "descripcion" está vacío
            if (entity.getDescripcion() == null || entity.getDescripcion().trim().isEmpty()) {
                errors.put("descripcion", "El campo descripción es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody Actividad entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "descripcion" está vacío
            if (entity.getDescripcion() == null || entity.getDescripcion().trim().isEmpty()) {
                errors.put("descripcion", "El campo descripción es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        Optional<Actividad> optional = service.findById(id);
        if (optional.isPresent()) {
            Actividad current = optional.get();
            current.setMateria(entity.getMateria());
            current.setSolicitudEmpresa(entity.getSolicitudEmpresa());
            current.setDescripcion(entity.getDescripcion());
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

    //To find by SolicitudEmpresa by MAC
    @GetMapping("/listarxSolicitudEmpresa")
    public ResponseEntity<?> listarxSolicitudEmpresa(@RequestBody SolicitudEmpresa entity) {
        return ResponseEntity.ok().body(service.buscarxSolicitud(entity));
    }

    @GetMapping("/listarxSolicitudEmpresa2")
    public ResponseEntity<?> listarxSolicitudEmpresa2(@RequestParam Integer id) {
        SolicitudEmpresa entity=new SolicitudEmpresa();
        entity.setId(id);
        return ResponseEntity.ok().body(service.buscarxSolicitud(entity));
    }

}
