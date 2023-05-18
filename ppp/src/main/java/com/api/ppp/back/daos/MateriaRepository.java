package com.api.ppp.back.daos;

import com.api.ppp.back.models.Materia;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends BaseRepository<Materia, Integer> {
    Optional<Materia> findByIdMateria(Integer idMateria);

    List<Materia> findByCarreraId(Integer id);

}
