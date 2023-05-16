package com.api.ppp.back.daos;

import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends BaseRepository<Estudiante, Integer> {

    Optional<Estudiante> findByUsuario(Usuario usuario);

}
