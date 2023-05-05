package com.api.ppp.back.daos;

import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Integer> {

    List<Usuario> findByCorreo(String correo);

}
