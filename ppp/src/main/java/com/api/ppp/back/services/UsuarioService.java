package com.api.ppp.back.services;

import com.api.ppp.back.models.Usuario;

public interface UsuarioService extends BaseService<Usuario, Integer> {

    public Usuario usuarioxcedula(String cedula);

}
