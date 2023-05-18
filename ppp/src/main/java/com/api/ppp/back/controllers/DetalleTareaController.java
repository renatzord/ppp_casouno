package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.DetalleTarea;
import com.api.ppp.back.services.DetalleTareaService;
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
@RequestMapping("/detalleTarea")
@CrossOrigin(origins="*")
public class DetalleTareaController {

    @Autowired
    private DetalleTareaService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<DetalleTarea> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody DetalleTarea entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "descripcion" está vacío
            if (entity.getDescripcion() == null || entity.getDescripcion().trim().isEmpty()) {
                errors.put("descripcion", "El campo descripción es obligatorio");
            }

            // Verificar si el campo "semana" está vacío
            if (entity.getSemana() == null || entity.getSemana().trim().isEmpty()) {
                errors.put("semana", "El campo semana es obligatorio");
            }

            // Verificar si el campo "horas" está vacío
            if (entity.getHoras() == null) {
                errors.put("horas", "El campo horas es obligatorio");
            }

            // Verificar si la llave foránea "tarea" está vacía
            if (entity.getTarea() == null) {
                errors.put("tarea", "El campo tarea es obligatorio");
            }

            // Verificar si la llave foránea "objetivoMateria" está vacía
            if (entity.getObjetivoMateria() == null) {
                errors.put("objetivoMateria", "El campo objetivoMateria es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody DetalleTarea entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "descripcion" está vacío
            if (entity.getDescripcion() == null || entity.getDescripcion().trim().isEmpty()) {
                errors.put("descripcion", "El campo descripción es obligatorio");
            }

            // Verificar si el campo "semana" está vacío
            if (entity.getSemana() == null || entity.getSemana().trim().isEmpty()) {
                errors.put("semana", "El campo semana es obligatorio");
            }

            // Verificar si el campo "horas" está vacío
            if (entity.getHoras() == null) {
                errors.put("horas", "El campo horas es obligatorio");
            }

            // Verificar si la llave foránea "tarea" está vacía
            if (entity.getTarea() == null) {
                errors.put("tarea", "El campo tarea es obligatorio");
            }

            // Verificar si la llave foránea "objetivoMateria" está vacía
            if (entity.getObjetivoMateria() == null) {
                errors.put("objetivoMateria", "El campo objetivoMateria es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        Optional<DetalleTarea> optional = service.findById(id);
        if (optional.isPresent()) {
            DetalleTarea current = optional.get();
            current.setTarea(entity.getTarea());
            current.setDescripcion(entity.getDescripcion());
            current.setHoras(entity.getHoras());
            current.setObjetivoMateria(entity.getObjetivoMateria());
            current.setSemana(entity.getSemana());
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
