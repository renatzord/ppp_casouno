package com.api.ppp.back.controllers;

import com.api.ppp.back.daos.AuthorityRepository;
import com.api.ppp.back.models.Authority;
import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Usuario;
import com.api.ppp.back.services.EstudianteService;
import com.api.ppp.back.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static com.api.ppp.back.constant.Validate.isPasswordSecure;

@Validated
@RestController
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;


    @PostMapping("/register")
    public ResponseEntity<?> crear(@Valid @RequestBody Estudiante entity) {
        if (!isPasswordSecure(entity.getUsuario().getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La contraseña no es segura");
        }
        String hashPwd = passwordEncoder.encode(entity.getUsuario().getPassword());
        entity.getUsuario().setPassword(hashPwd);
        Estudiante estudiante = estudianteService.save(entity);
        Authority role = new Authority();
        role.setName("ROLE_ESTUD");
        role.setUsuario(estudiante.getUsuario());
        authorityRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
    }

    @RequestMapping("/ingresar")
    public Usuario getUserDetailsAfterLogin(Authentication authentication) {
        Optional<Usuario> usuario = usuarioService.findByCorreo(authentication.getName());
        return usuario.orElse(null);
    }

}
