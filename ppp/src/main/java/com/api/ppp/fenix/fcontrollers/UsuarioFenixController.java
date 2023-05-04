package com.api.ppp.fenix.fcontrollers;

import com.api.ppp.fenix.fmodels.UsuarioFenix;
import com.api.ppp.fenix.fservices.UsuarioFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/usuariofenix")
public class UsuarioFenixController {

    @Autowired
    private UsuarioFenixService service;

    @GetMapping("/buscar/{cedula}")
    public ResponseEntity<?> buscarID(@PathVariable("cedula") String cedula) {
        Optional<UsuarioFenix> current = Optional.ofNullable(service.findByCedula(cedula));
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

}
