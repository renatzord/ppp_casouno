package com.api.ppp.fenix.fcontrollers;

import com.api.ppp.back.models.Usuario;
import com.api.ppp.back.services.UsuarioService;
import com.api.ppp.fenix.fmodels.UsuarioFenix;
import com.api.ppp.fenix.fservices.UsuarioFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/usuariofenix")
@CrossOrigin(origins="*")
public class UsuarioFenixController {

    @Autowired
    private UsuarioFenixService service;

    @Autowired
    private UsuarioService usuService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/buscarusuario/{cedula}")
    public ResponseEntity<?> buscarCedula(@PathVariable("cedula") String cedula) {
        Optional<UsuarioFenix> current = Optional.ofNullable(service.findByCedula(cedula));
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscaralumnocedula/{cedula}")
    public ResponseEntity<?> buscarCedulaEstidiantes(@PathVariable("cedula") String cedula) {
        Optional<UsuarioFenix> current = Optional.ofNullable(service.findByCedulaEstudiante(cedula));
        Optional<Usuario> existe = Optional.ofNullable(usuService.usuarioxcedula(cedula));
        if(current.isPresent()) {
            if (existe.isPresent()) {
                return ResponseEntity.badRequest()
                        .body(Collections
                                .singletonMap("Mensaje", "Ya existe el alumno"));
            }
            else return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.badRequest()
                .body(Collections
                        .singletonMap("Mensaje","No se encontro estudiante para la cédula " + cedula));
    }

    @GetMapping("/buscarusuario/{nombres}/{correo}/{tipo}")
    public ResponseEntity<?> buscarNombreCorreoTipo(@PathVariable("nombres") String nombres,
                                                @PathVariable("correo") String correo,
                                                @PathVariable("tipo") Integer tipo) {
        Optional<UsuarioFenix> current = Optional.ofNullable(service.findByNombresAndCorreoAndTipo(nombres, correo, tipo));
        if (current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscaralumno/{nombres}/{correo}")
    public ResponseEntity<?> buscarNombreCorreoAlumno(@PathVariable("nombres") String nombres,
                                                    @PathVariable("correo") String correo) {
        Optional<UsuarioFenix> current = Optional.ofNullable(service.findByNombresAndCorreoAlumnos(nombres, correo));
        if (current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

}
