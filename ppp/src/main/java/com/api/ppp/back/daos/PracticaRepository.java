package com.api.ppp.back.daos;

import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Practica;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.api.ppp.back.models.TutorInstituto;
import java.util.Optional;

@Repository
public interface PracticaRepository extends BaseRepository<Practica, Integer> {

    List<Practica> findByTutorInstitutoUsuarioId(Integer id);
    Optional<List<Practica>>findByTutorInstituto(TutorInstituto tutorInstituto);

    Optional<Practica>findByEstudiante(Estudiante estudiante);

}
