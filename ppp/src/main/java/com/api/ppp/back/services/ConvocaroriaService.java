package com.api.ppp.back.services;

import com.api.ppp.back.models.Convocatoria;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ConvocaroriaService extends BaseService<Convocatoria, Integer> {

    public List<Convocatoria> convocatoriaActivas(Integer car_id);

    List<Convocatoria> listConvocatorias();

    Optional<Convocatoria> findBySolicitudEmpresaId(Integer id);



}
