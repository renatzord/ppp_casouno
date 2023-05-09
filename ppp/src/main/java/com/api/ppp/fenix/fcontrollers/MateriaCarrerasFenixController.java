package com.api.ppp.fenix.fcontrollers;

import com.api.ppp.back.models.Carrera;
import com.api.ppp.back.models.Materia;
import com.api.ppp.back.services.CarreraService;
import com.api.ppp.back.services.MateriaService;
import com.api.ppp.fenix.fmodels.MateriaCarrera;
import com.api.ppp.fenix.fservices.CarreraMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fenix")
public class MateriaCarrerasFenixController {

    @Autowired
    private CarreraMateriaService service;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private CarreraService carreraService;

    @GetMapping("/listarcarreras")
    public ResponseEntity<?> listarCarreras() {
        Optional<List<MateriaCarrera>> current = Optional.ofNullable(service.findAllCarreras());
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listarmaterias")
    public ResponseEntity<?> listarMaterias() {
        Optional<List<MateriaCarrera>> current = Optional.ofNullable(service.findAllMaterias());
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listarmateriasxnombre/{nombre}/{idcarrera}")
    public ResponseEntity<?> listarMateriasxNombre(@PathVariable("nombre") String nombre,
                                                   @PathVariable("idcarrera") Integer idCarrera) {
        Optional<List<MateriaCarrera>> current = Optional.ofNullable(service.findAllMateriasxNombre(nombre,idCarrera));
        if(current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/llenardatos")
    public String llenarDatos(){

        List<MateriaCarrera> listacarrera=service.findAllCarreras();
        List<MateriaCarrera> listamateria=service.findAllMaterias();

        if(listacarrera.size()==0 || listamateria.size()==0){
            return "Algo Malio Sal";
        }else{
            List<Carrera> carreras= carreraService.findAll();
            for (MateriaCarrera fenix: listacarrera) {
                boolean ban=true;
                for (Carrera base: carreras) {
                    if(base.getIdCarrera()== fenix.getCarreraMateriaId())ban=false;
                }
                if(ban){
                    Carrera nueva = new Carrera();
                    nueva.setIdCarrera(fenix.getCarreraMateriaId());
                    nueva.setNombre(fenix.getNombre());
                    nueva.setActivo(true);
                    carreraService.save(nueva);
                }
            }
            carreras= carreraService.findAll();
            List<Materia> materias= materiaService.findAll();
            for (MateriaCarrera fenix: listamateria) {
                boolean ban=true;
                if(materiaService.findByIdMateria(fenix.getCarreraMateriaId())!=null){
                    ban=false;
                }
                if(ban && fenix.getCiclo()>3){
                    Carrera existe = new Carrera();
                    for (Carrera car: carreras) {
                        if(car.getIdCarrera()==fenix.getCarreraId())existe=car;
                    }
                    Materia nueva=new Materia();
                    nueva.setIdMateria(fenix.getCarreraMateriaId());
                    nueva.setNombre(fenix.getNombre());
                    nueva.setCarrera(existe);
                    materiaService.save(nueva);
                }
            }
            return "Todo bien todo correcto y yo que me alegro";
        }
    }

}
