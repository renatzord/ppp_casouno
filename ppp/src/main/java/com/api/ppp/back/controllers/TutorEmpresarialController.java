package com.api.ppp.back.controllers;

import com.api.ppp.back.daos.AuthorityRepository;
import com.api.ppp.back.models.Authority;
import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.services.TutorEmpresarialService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.api.ppp.back.constant.Validate.isPasswordSecure;

@RestController
@RequestMapping("/tutorEmpresa")
@CrossOrigin(origins="*")
public class TutorEmpresarialController {

    @Autowired
    private TutorEmpresarialService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<TutorEmpresarial> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody TutorEmpresarial entity, @RequestParam String rol) {
        try {
            if (StringUtils.isEmpty(entity.getCargo())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El campo 'cargo' es obligatorio");
            }
            if (!isPasswordSecure(entity.getUsuario().getPassword())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La contraseña debe ser segura");
            }
            String hashPwd = passwordEncoder.encode(entity.getUsuario().getPassword());
            entity.getUsuario().setPassword(hashPwd);
            TutorEmpresarial tutor = service.save(entity);
            if (tutor.getId() > 0) {
                Authority role = new Authority();
                role.setName(rol);
                role.setUsuario(tutor.getUsuario());
                authorityRepository.save(role);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("Los detalles del usuario proporcionados se han registrado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se produjo un error al guardar el usuario");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo una excepción debido a " + e.getMessage());
        }
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody TutorEmpresarial entity) {
        if (StringUtils.isEmpty(entity.getCargo())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El campo 'cargo' es obligatorio");
        }
        if (!isPasswordSecure(entity.getUsuario().getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La contraseña debe ser segura");
        }
        Optional<TutorEmpresarial> optional = service.findById(id);
        if (optional.isPresent()) {
            String hashPwd = passwordEncoder.encode(entity.getUsuario().getPassword());
            entity.getUsuario().setPassword(hashPwd);
            TutorEmpresarial current = optional.get();
            current.setEmpresa(entity.getEmpresa());
            current.setUsuario(entity.getUsuario());
            current.setCargo(entity.getCargo());
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
