package com.api.ppp.back.daos;

import com.api.ppp.back.models.Authority;
import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface AuthorityRepository extends BaseRepository<Authority, Integer> {

    Set<Authority> findByUsuario(Usuario usuario);

}
