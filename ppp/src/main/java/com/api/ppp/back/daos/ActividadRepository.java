package com.api.ppp.back.daos;

import com.api.ppp.back.models.Actividad;
import com.api.ppp.back.models.SolicitudEmpresa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActividadRepository extends BaseRepository<Actividad, Integer> {

    Optional <List<Actividad>> findAllBySolicitudEmpresa(SolicitudEmpresa solicitudEmpresa);

}
