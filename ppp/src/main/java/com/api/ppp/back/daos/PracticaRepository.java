package com.api.ppp.back.daos;

import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.models.TutorInstituto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PracticaRepository extends BaseRepository<Practica, Integer> {

    Optional<List<Practica>>findByTutorInstituto(TutorInstituto tutorInstituto);

    Optional<Practica>findByEstudiante(Estudiante estudiante);

    Optional<List<Practica>>findByTutorEmpresarial(TutorEmpresarial tutorInstituto);

}
