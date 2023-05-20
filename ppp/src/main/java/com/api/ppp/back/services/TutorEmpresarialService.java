package com.api.ppp.back.services;

import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.models.Usuario;

public interface TutorEmpresarialService extends BaseService<TutorEmpresarial, Integer> {

    TutorEmpresarial tutorxUsuario(Usuario usuario);

}
