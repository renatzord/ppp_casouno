package com.api.ppp.back.services;

import com.api.ppp.back.models.ResultadoMateria;

import java.util.List;

public interface ResultadoMateriaService extends BaseService<ResultadoMateria, Integer> {

    List<ResultadoMateria> findByCarreraId(Integer id);

}
