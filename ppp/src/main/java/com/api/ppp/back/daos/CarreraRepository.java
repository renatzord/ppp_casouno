package com.api.ppp.back.daos;

import com.api.ppp.back.models.Carrera;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarreraRepository extends BaseRepository<Carrera, Integer> {

    Optional<Carrera> findByIdCarrera(Integer idCarrera);

}
