package com.api.ppp.back.daos;

import com.api.ppp.back.models.Convocatoria;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ConvocatoriaRepository extends BaseRepository<Convocatoria, Integer> {

    Optional<List<Convocatoria>> findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(Date fechaInicio, Date fechaFin);

}
