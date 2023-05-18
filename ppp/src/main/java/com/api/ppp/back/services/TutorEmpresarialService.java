package com.api.ppp.back.services;

import com.api.ppp.back.models.TutorEmpresarial;

import java.util.Optional;

public interface TutorEmpresarialService extends BaseService<TutorEmpresarial, Integer> {

    Optional<TutorEmpresarial> buscarGerenteUsuario(Integer id);

}
