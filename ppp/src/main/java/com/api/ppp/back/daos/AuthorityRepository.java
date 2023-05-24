package com.api.ppp.back.daos;

import com.api.ppp.back.models.Authority;
import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface AuthorityRepository extends BaseRepository<Authority, Integer> {

    // This method will be util if you want a user with more than a single ROLE_
    Set<Authority> findByUsuario(Usuario usuario);

    List<Authority> findByName(String name);

}
