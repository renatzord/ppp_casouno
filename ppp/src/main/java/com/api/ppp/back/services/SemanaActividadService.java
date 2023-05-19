package com.api.ppp.back.services;

import com.api.ppp.back.models.SemanaActividad;

import java.util.List;

public interface SemanaActividadService extends BaseService<SemanaActividad, Integer> {

    List<SemanaActividad> listarPracticaId(Integer id);

}
