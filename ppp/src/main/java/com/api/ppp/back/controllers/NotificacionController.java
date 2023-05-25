package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Usuario;
import com.api.ppp.back.services.NotificacionService;
import com.api.ppp.back.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notificacion")
@CrossOrigin(origins="*")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(@PathVariable("usuarioid") Integer id,@PathVariable("tipo") Integer tipo) {
        return ResponseEntity.ok().body(service.notificacionxtipo(usuarioService.findById(id).orElse(null),tipo));
    }

}
