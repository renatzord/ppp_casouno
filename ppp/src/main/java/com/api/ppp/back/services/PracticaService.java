package com.api.ppp.back.services;

import com.api.ppp.back.models.Practica;

import java.util.List;

public interface PracticaService extends BaseService<Practica, Integer> {

    List<Practica> findByTutorInstitutoUsuarioId(Integer id);

}
