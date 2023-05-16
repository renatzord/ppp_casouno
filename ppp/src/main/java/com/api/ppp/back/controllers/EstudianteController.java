package com.api.ppp.back.controllers;

import com.api.ppp.back.models.*;
import com.api.ppp.back.services.EstudianteService;
import com.api.ppp.back.services.PracticaService;
import com.api.ppp.back.services.TutorInstitutoService;
import com.api.ppp.back.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.api.ppp.back.constant.Validate.isPasswordSecure;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin(origins="*")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PracticaService practicaService;

    @Autowired
    private TutorInstitutoService tutorInstitutoService;

    @Autowired
    private UsuarioService usuarioService;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Estudiante> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Estudiante entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    // To find one record and update it, specifically by a unique identifier (PK or ID)
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Estudiante entity) {
        if (!isPasswordSecure(entity.getUsuario().getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST) .body("Password must be secure");
        }
        Optional<Estudiante> optional = service.findById(id);
        if(optional.isPresent()) {
            String hashPwd = passwordEncoder.encode(entity.getUsuario().getPassword());
            entity.getUsuario().setPassword(hashPwd);
            Estudiante current = optional.get();
            current.setUsuario(entity.getUsuario());
            current.setIdEstudiante(entity.getIdEstudiante());
            current.setCarrera(entity.getCarrera());
            current.setPeriodo(entity.getPeriodo());
            current.setCiclo(entity.getCiclo());
            current.setHorasCumplidas(entity.getHorasCumplidas());
            current.setPrioridad(entity.getPrioridad());
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

    @GetMapping("/listarxtutoracademico/{id}")
    public ResponseEntity<?> listar(@PathVariable("id") Integer id) {
        List<Estudiante> estudiantes = new ArrayList<>();
        TutorInstituto docente=tutorInstitutoService.findById(id).orElse(null);
        for (Practica pra: practicaService.practicaxDocente(docente)) {
            estudiantes.add(pra.getEstudiante());
        }
        return ResponseEntity.ok().body(estudiantes);
    }

    @GetMapping("/buscarxusuario/{id}")
    public ResponseEntity<?> buscarxUsuario(@PathVariable("id") Integer id) {
        Optional<Estudiante> current = Optional.ofNullable(service.estudiantexUsuario(usuarioService.findById(id).orElse(null)));
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

}
