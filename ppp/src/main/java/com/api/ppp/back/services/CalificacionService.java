package com.api.ppp.back.services;

import com.api.ppp.back.models.Calificacion;

import java.util.List;

public interface CalificacionService extends BaseService<Calificacion, Integer> {

    List<Calificacion> findByPracticaId(Integer id);

}
