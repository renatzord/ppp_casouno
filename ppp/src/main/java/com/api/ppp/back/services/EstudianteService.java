package com.api.ppp.back.services;

import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Usuario;

public interface EstudianteService extends BaseService<Estudiante, Integer> {

    public Estudiante estudiantexUsuario(Usuario usuario);
}
