package com.api.ppp.back.daos;

import com.api.ppp.back.models.Convocatoria;
import com.api.ppp.back.models.SolicitudEstudiante;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitudEstudianteRepository extends BaseRepository<SolicitudEstudiante, Integer> {

    Optional<List<SolicitudEstudiante>> findAllByConvocatoria(Convocatoria convocatoria);

    Optional<List<SolicitudEstudiante>> findByConvocatoriaAndEstado(Convocatoria convocatoria,Integer estado);

}
