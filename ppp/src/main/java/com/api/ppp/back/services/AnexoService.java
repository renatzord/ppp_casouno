package com.api.ppp.back.services;

import com.api.ppp.back.models.Anexos;
import com.api.ppp.back.models.Practica;

import java.util.List;

public interface AnexoService extends BaseService<Anexos, Integer> {

    Anexos anexoTipo(Integer id, Integer tipo);

}
