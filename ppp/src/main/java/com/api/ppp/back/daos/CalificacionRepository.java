package com.api.ppp.back.daos;

import com.api.ppp.back.models.Calificacion;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalificacionRepository extends BaseRepository<Calificacion, Integer> {

    List<Calificacion> findByPracticaId(Integer id);

}
