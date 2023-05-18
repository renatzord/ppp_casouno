package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.Materia;
import com.api.ppp.back.models.ObjetivoMateria;
import com.api.ppp.back.services.MateriaService;
import com.api.ppp.back.services.ObjetivoMateriaService;
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

@RequestMapping("/objetivoMateria")
@RestController
@CrossOrigin(origins="*")
public class ObjetivoMateriaController {

    @Autowired
    private ObjetivoMateriaService service;
    @Autowired
    private MateriaService serviceMateria;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<ObjetivoMateria> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@Valid @RequestBody ObjetivoMateria entity, BindingResult bindingResult) {
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
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody ObjetivoMateria entity, BindingResult bindingResult) {
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

        Optional<ObjetivoMateria> optional = service.findById(id);
        if (optional.isPresent()) {
            ObjetivoMateria current = optional.get();
            current.setDescripcion(entity.getDescripcion());
            current.setMateria(entity.getMateria());
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

    @GetMapping("/listarxmateria/{id}")
    public ResponseEntity<?> listar(@PathVariable("id") Integer id) {
        Materia materia=serviceMateria.findById(id).orElse(null);
        return ResponseEntity.ok().body(service.objetivoxMateria(materia));
    }

}
