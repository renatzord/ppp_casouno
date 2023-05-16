package com.api.ppp.back.services;

import com.api.ppp.back.models.Convocatoria;

import java.util.Date;
import java.util.List;

public interface ConvocaroriaService extends BaseService<Convocatoria, Integer> {

    public List<Convocatoria> convocatoriaActivas(Date fecha);

}
