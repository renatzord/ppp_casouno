package com.api.ppp.back.services;

import com.api.ppp.back.models.Visita;

import java.util.Optional;

public interface VisitaService extends BaseService<Visita, Integer> {

    Visita findUltimaVisitaByPractica(Integer id);

}
