package com.api.ppp.back.daos;

import com.api.ppp.back.models.Materia;
import com.api.ppp.back.models.ObjetivoMateria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjetivoMateriaRepository extends BaseRepository<ObjetivoMateria, Integer> {

    Optional <List<ObjetivoMateria>> findByMateria(Materia materia);

}
