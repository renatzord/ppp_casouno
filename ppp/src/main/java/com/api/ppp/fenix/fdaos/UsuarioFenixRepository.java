package com.api.ppp.fenix.fdaos;

import com.api.ppp.fenix.fmodels.UsuarioFenix;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioFenixRepository extends CrudRepository<UsuarioFenix,Integer> {

    Optional<UsuarioFenix> findByCedula(String cedula);

}
