package com.api.ppp.back.daos;

import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.TutorEmpresarial;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.api.ppp.back.models.TutorInstituto;
import java.util.Optional;

@Repository
public interface PracticaRepository extends BaseRepository<Practica, Integer> {

    List<Practica> findByTutorInstitutoUsuarioId(Integer id);
    Optional<List<Practica>>findByTutorInstituto(TutorInstituto tutorInstituto);

    Optional<Practica>findByEstudiante(Estudiante estudiante);

    Optional<List<Practica>>findByTutorEmpresarial(TutorEmpresarial tutorInstituto);

    List<Practica> findByEstudianteUsuarioId(Integer id);


}
