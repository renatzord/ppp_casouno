package com.api.ppp.back.services;

import com.api.ppp.back.models.Materia;
import com.api.ppp.back.models.ObjetivoMateria;

import java.util.List;

public interface ObjetivoMateriaService extends BaseService<ObjetivoMateria, Integer> {

    public List<ObjetivoMateria> objetivoxMateria(Materia materia);
}
