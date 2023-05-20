package com.api.ppp.back.daos;

import com.api.ppp.back.models.TutorInstituto;
import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorInstitutoRepository extends BaseRepository<TutorInstituto, Integer> {

    Optional<TutorInstituto> findByUsuario(Usuario usuario);

}
