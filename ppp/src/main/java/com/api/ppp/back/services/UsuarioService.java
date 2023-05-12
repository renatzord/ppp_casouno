package com.api.ppp.back.services;

import com.api.ppp.back.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService extends BaseService<Usuario, Integer> {


    //List<Usuario> findByCorreo(String correo);

    public Usuario usuarioxcedula(String cedula);

    Optional<Usuario> findByCorreo(String correo);


}
