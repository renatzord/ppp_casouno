package com.api.ppp.back.controllers;

import com.api.ppp.back.models.Convenio;
import com.api.ppp.back.services.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    @Autowired
    private ConvenioService service;

    // To list all records
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    // To find one record, specifically by a unique identifier (PK or ID)
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<Convenio> current = service.findById(id);
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    // To create a record
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Convenio entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    // To find one record and update it, specifically by a unique identifier (PK or ID)
    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Convenio entity) {
        Optional<Convenio> optional = service.findById(id);
        if(optional.isPresent()) {
            Convenio current = optional.get();
            current.setCarrera(entity.getCarrera());
            current.setEmpresa(entity.getEmpresa());
            current.setNumero(entity.getNumero());
            current.setFirmaInst(entity.getFirmaInst());
            current.setFechaFin(entity.getFechaFin());
            current.setFechaInicio(entity.getFechaInicio());
            current.setSolicitudEmpresas(entity.getSolicitudEmpresas());
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

    // to find a list of Convenio referenced to a Empresa
    @GetMapping("/buscar/empresa/{id}")
    public ResponseEntity<?> buscarPorEmpresa(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.busrcarPorEmpresa(id));
    }

    @PostMapping("/guardarpdf")
    public ResponseEntity<String> guardarDocumento(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id")Integer id) {
        try {
            Optional<Convenio> optional = service.findById(id);
            if (optional.isPresent()) {
                Convenio current = optional.get();
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
        Optional<Convenio> optional = service.findById(id);
        if (optional.isPresent()) {
            Convenio current = optional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment().filename(current.getNumero()+"-"+current.getFechaInicio().getYear()+".pdf").build());
            return new ResponseEntity<>(current.getUrl(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // To find the last Convenio record by his Empresa ID
    @GetMapping("buscar/ultimo/empresa/{id}")
    public ResponseEntity<?> buscarUltimoEmpresaID(Integer id) {
        return ResponseEntity.ok().body(service.findLatestByEmpresaId(id));
    }

    // To find the last Convenio record
    @GetMapping("buscar/ultimo")
    public ResponseEntity<?> buscarUltimo(Integer id) {
        return ResponseEntity.ok().body(service.findLatestConvenio());
    }

}
