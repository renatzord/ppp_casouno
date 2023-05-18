package com.api.ppp.back.services;

import com.api.ppp.back.models.Materia;

import java.util.List;

public interface MateriaService extends BaseService<Materia, Integer> {

    public boolean findByIdMateria(Integer idMateria);

    List<Materia> findByCarreraId(Integer id);

}
