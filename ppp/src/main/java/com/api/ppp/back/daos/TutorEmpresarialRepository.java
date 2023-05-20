package com.api.ppp.back.daos;

import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorEmpresarialRepository extends BaseRepository<TutorEmpresarial, Integer> {

    Optional<TutorEmpresarial> findByUsuario(Usuario usuario);

}
