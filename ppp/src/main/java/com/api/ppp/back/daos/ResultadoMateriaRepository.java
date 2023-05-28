package com.api.ppp.back.daos;

import com.api.ppp.back.models.ResultadoMateria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoMateriaRepository extends BaseRepository<ResultadoMateria, Integer> {

    List<ResultadoMateria> findByCarreraId(Integer id);

}
