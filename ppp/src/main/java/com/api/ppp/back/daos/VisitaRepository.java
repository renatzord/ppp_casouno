package com.api.ppp.back.daos;

import com.api.ppp.back.models.Visita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitaRepository extends BaseRepository<Visita, Integer> {

    @Query("SELECT v FROM Visita v WHERE v.practica.id = :id AND v.id = (SELECT MAX(v2.id) FROM Visita v2 WHERE v2.practica.id = :id)")
    Optional<Visita> findUltimaVisitaByPractica(Integer id);

}
