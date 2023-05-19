package com.api.ppp.back.daos;

import com.api.ppp.back.models.SemanaActividad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemanaActividadRepository extends BaseRepository<SemanaActividad, Integer> {

    List<SemanaActividad> findByPracticaId(Integer id);

}
