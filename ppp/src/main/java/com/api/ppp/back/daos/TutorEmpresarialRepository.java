package com.api.ppp.back.daos;

import com.api.ppp.back.models.TutorEmpresarial;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorEmpresarialRepository extends BaseRepository<TutorEmpresarial, Integer> {

    Optional<TutorEmpresarial> findByUsuarioId(Integer id);

}
