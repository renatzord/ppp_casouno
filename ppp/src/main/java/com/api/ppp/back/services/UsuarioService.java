package com.api.ppp.back.services;

import com.api.ppp.back.models.Usuario;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Integer> {

    List<Usuario> findByCorreo(String correo);

}
