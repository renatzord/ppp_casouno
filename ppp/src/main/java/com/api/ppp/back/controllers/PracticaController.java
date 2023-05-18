package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.Usuario;
import com.api.ppp.back.services.EstudianteService;
import com.api.ppp.back.services.PracticaService;
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
@RequestMapping("/practica")
@CrossOrigin(origins="*")
public class PracticaController {

    @Autowired
    private PracticaService service;

    @Autowired
    private EstudianteService estudianteService;


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
    public ResponseEntity<?> crear(@Valid @RequestBody Practica entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "periodo" está vacío
            if (entity.getPeriodo() == null || entity.getPeriodo().trim().isEmpty()) {
                errors.put("periodo", "El campo periodo es obligatorio");
            }

            // Verificar si el campo "nSemanas" es menor o igual a cero
            if (entity.getNSemanas() <= 0) {
                errors.put("nSemanas", "El campo nSemanas debe ser mayor a cero");
            }

            // Verificar si el campo "inicio" es nulo
            if (entity.getInicio() == null) {
                errors.put("inicio", "El campo inicio es obligatorio");
            }

            // Verificar si el campo "fin" es nulo
            if (entity.getFin() == null) {
                errors.put("fin", "El campo fin es obligatorio");
            }

            // Verificar si el campo "concluciones" está vacío
            if (entity.getConcluciones() == null || entity.getConcluciones().trim().isEmpty()) {
                errors.put("concluciones", "El campo concluciones es obligatorio");
            }

            // Verificar si el campo "departamento" está vacío
            if (entity.getDepartamento() == null || entity.getDepartamento().trim().isEmpty()) {
                errors.put("departamento", "El campo departamento es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @Valid @RequestBody Practica entity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            // Verificar si el campo "periodo" está vacío
            if (entity.getPeriodo() == null || entity.getPeriodo().trim().isEmpty()) {
                errors.put("periodo", "El campo periodo es obligatorio");
            }

            // Verificar si el campo "nSemanas" es menor o igual a cero
            if (entity.getNSemanas() <= 0) {
                errors.put("nSemanas", "El campo nSemanas debe ser mayor a cero");
            }

            // Verificar si el campo "inicio" es nulo
            if (entity.getInicio() == null) {
                errors.put("inicio", "El campo inicio es obligatorio");
            }

            // Verificar si el campo "fin" es nulo
            if (entity.getFin() == null) {
                errors.put("fin", "El campo fin es obligatorio");
            }

            // Verificar si el campo "concluciones" está vacío
            if (entity.getConcluciones() == null || entity.getConcluciones().trim().isEmpty()) {
                errors.put("concluciones", "El campo concluciones es obligatorio");
            }

            // Verificar si el campo "departamento" está vacío
            if (entity.getDepartamento() == null || entity.getDepartamento().trim().isEmpty()) {
                errors.put("departamento", "El campo departamento es obligatorio");
            }

            if (!errors.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
            }
        }

        Optional<Practica> optional = service.findById(id);
        if (optional.isPresent()) {
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
            current.setEstado(entity.getEstado());
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

    // List of all assigned internships according the Tutor_Instituto linked an User
    @GetMapping("/listar/usuario/{id}")
    public ResponseEntity<?> listarByUsuario(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findByTutorInstitutoUsuarioId(id));
    }

    @GetMapping("/buscarxestudiante/{idEstudiante}")
    public ResponseEntity<?> buscarxEstudiante(@PathVariable("idEstudiante") Integer id) {
        Optional<Practica> current = Optional.ofNullable(service.practicaxEstudiante(estudianteService.findById(id).orElse(null)));
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

}
