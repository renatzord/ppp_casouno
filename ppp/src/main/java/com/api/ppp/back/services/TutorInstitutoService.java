package com.api.ppp.back.services;

import com.api.ppp.back.models.TutorInstituto;
import com.api.ppp.back.models.Usuario;

public interface TutorInstitutoService extends BaseService<TutorInstituto, Integer> {

    TutorInstituto tutorxUsuario(Usuario usuario);

}
