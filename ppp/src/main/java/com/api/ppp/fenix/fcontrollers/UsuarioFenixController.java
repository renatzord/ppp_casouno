package com.api.ppp.fenix.fcontrollers;

import com.api.ppp.fenix.fmodels.UsuarioFenix;
import com.api.ppp.fenix.fservices.UsuarioFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuariofenix")
@CrossOrigin(origins="*")
public class UsuarioFenixController {

    @Autowired
    private UsuarioFenixService service;

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
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
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
