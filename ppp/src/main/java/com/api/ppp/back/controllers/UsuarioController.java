package com.api.ppp.back.controllers;

import com.api.ppp.back.daos.AuthorityRepository;
import com.api.ppp.back.models.Authority;
import com.api.ppp.back.models.TutorInstituto;
import com.api.ppp.back.models.Usuario;
import com.api.ppp.back.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.api.ppp.back.constant.Validate.isPasswordSecure;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Usuario> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Usuario entity, @RequestParam String rol) {
        if (!isPasswordSecure(entity.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST) .body("Password must be secure");
        }
        String hashPwd = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(hashPwd);
        Usuario usuario = service.save(entity);
        Authority role = new Authority();
        role.setName(rol);
        role.setUsuario(usuario);
        authorityRepository.save(role);
        return ResponseEntity .status(HttpStatus.CREATED).body("Usuario registrado con exito.");
    }

    // To list users by their roles
    @GetMapping("/listar/rol")
    public ResponseEntity<?> listarRol(String rol) {
        return ResponseEntity.ok().body(authorityRepository.findByName(rol));
    }

}
