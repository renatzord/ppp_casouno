package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Usuario;
import com.api.ppp.back.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signUp")
    public ResponseEntity<?> crear(@RequestBody Usuario entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @RequestMapping("/logIn")
    public Usuario getUserDetailsAfterLogin(Authentication authentication) {
        List<Usuario> usuarios = service.findByCorreo(authentication.getName());
        if (usuarios.size() > 0) {
            return usuarios.get(0);
        } else {
            return null;
        }

    }

}
