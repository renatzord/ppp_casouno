package com.api.ppp.back.daos;

import com.api.ppp.back.models.Convocatoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ConvocatoriaRepository extends BaseRepository<Convocatoria, Integer> {

    Optional<List<Convocatoria>> findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(Date fechaInicio, Date fechaFin);

    @Query(value="select cov from Convocatoria cov " +
            "inner join SolicitudEmpresa sol on sol = cov.solicitudEmpresa " +
            "inner join Convenio con on con = sol.convenio " +
            "where con.carrera.id =:carreraId "+
            "AND cov.fechaInicio <= CURRENT_DATE " +
            "AND cov.fechaFin >= CURRENT_DATE")
    Optional<List<Convocatoria>> convocatoriasActivasxCarrera(@Param("carreraId") Integer carreraId);

    @Query(value = "SELECT cov FROM Convocatoria cov WHERE CURRENT_DATE BETWEEN cov.fechaInicio AND cov.fechaFin")
    List<Convocatoria> findAllConvocatorias();

    List<Convocatoria> findBySolicitudEmpresaId(Integer id);

}
