package com.api.ppp.back.controllers;


import com.api.ppp.back.models.Notificacion;
import com.api.ppp.back.services.NotificacionService;
import com.api.ppp.back.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Notificacion entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Notificacion entity) {
        Optional<Notificacion> optional = service.findById(id);
        if(optional.isPresent()) {
            Notificacion current = optional.get();
            current.setEstado(entity.isEstado());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(current));
        }
        return ResponseEntity.notFound().build();
    }

}
