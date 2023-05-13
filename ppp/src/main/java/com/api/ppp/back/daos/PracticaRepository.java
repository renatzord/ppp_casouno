package com.api.ppp.back.daos;

import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracticaRepository extends BaseRepository<Practica, Integer> {

    List<Practica> findByTutorInstituto_Usuario(Usuario usuario);

}
