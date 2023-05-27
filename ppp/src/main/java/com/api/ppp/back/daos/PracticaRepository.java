package com.api.ppp.back.daos;

import com.api.ppp.back.models.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PracticaRepository extends BaseRepository<Practica, Integer> {

    List<Practica> findByTutorInstitutoUsuarioId(Integer id);

    List<Practica> findByTutorEmpresarialUsuarioId(Integer id);

    Optional<List<Practica>>findByTutorInstituto(TutorInstituto tutorInstituto);

    Optional<Practica>findByEstudiante(Estudiante estudiante);

    Optional<List<Practica>>findByTutorEmpresarial(TutorEmpresarial tutorInstituto);

    List<Practica> findByEstudianteUsuarioId(Integer id);

    List<Practica> findByConvocatoriaId(Integer id);

    List<Practica> findByConvocatoria_SolicitudEmpresa_Convenio_Empresa(Empresa empresa);

}
