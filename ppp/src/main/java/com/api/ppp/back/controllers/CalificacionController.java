package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Accion;
import com.api.ppp.back.models.Calificacion;
import com.api.ppp.back.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private CalificacionService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Calificacion> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Calificacion entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    // To find one record and update it, specifically by a unique identifier (PK or ID)
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Calificacion entity) {
        Optional<Calificacion> optional = service.findById(id);
        if(optional.isPresent()) {
            Calificacion current = optional.get();
            current.setPractica(entity.getPractica());
            current.setA(entity.getA());
            current.setB(entity.getB());
            current.setC(entity.getC());
            current.setD(entity.getD());
            current.setE(entity.getE());
            current.setTutor(entity.getTutor());
            current.setTotal(entity.getTotal());
            current.setUrl(entity.getUrl());
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

    @PostMapping("/guardarpdf")
    public ResponseEntity<String> guardarDocumento(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id")Integer id) {
        try {
            Optional<Calificacion> optional = service.findById(id);
            if (optional.isPresent()) {
                Calificacion current = optional.get();
                current.setUrl(archivo.getBytes());
                service.save(current);
                return ResponseEntity.ok("El documento se ha guardado correctamente. "+current.getUrl().length);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el documento.");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el documento.");
    }

    @GetMapping("/mostrarpdf/{id}")
    public ResponseEntity<byte[]> obtenerDocumento(@PathVariable("id") Integer id) {
        Optional<Calificacion> optional = service.findById(id);
        if (optional.isPresent()) {
            Calificacion current = optional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment().filename(current.getPractica().getId()+".pdf").build());
            return new ResponseEntity<>(current.getUrl(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // TO find a list of Calificacion assiated to a Practica ID
    @GetMapping("/listar/practica/{id}")
    public ResponseEntity<?> buscarPorTistaId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findByPracticaId(id));
    }


}
