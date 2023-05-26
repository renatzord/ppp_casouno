package com.api.ppp.back.controllers;


import com.api.ppp.back.models.Notificacion;
import com.api.ppp.back.services.NotificacionService;
import com.api.ppp.back.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notificacion")
@CrossOrigin(origins="*")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar/{usuarioid}/{tipo}")
    public ResponseEntity<?> listar(@PathVariable("usuarioid") Integer id,@PathVariable("tipo") Integer tipo) {
        return ResponseEntity.ok().body(service.notificacionxtipo(usuarioService.findById(id).orElse(null),tipo));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Notificacion entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PostMapping("/editar/{id}/{estado}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @PathVariable("estado") Boolean estado) {
        Optional<Notificacion> optional = service.findById(id);
        if(optional.isPresent()) {
            Notificacion current = optional.get();
            current.setEstado(estado);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(current));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listarestudiante/{usuarioid}")
    public ResponseEntity<?> listarest(@PathVariable("usuarioid") Integer id) {
        return ResponseEntity.ok().body(service.notificacionxtipo(usuarioService.findById(id).orElse(null),3));
    }

}
