package com.api.ppp.fenix.fdaos;

import com.api.ppp.fenix.fmodels.UsuarioFenix;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioFenixRepository extends CrudRepository<UsuarioFenix,Integer> {

    Optional<UsuarioFenix> findByCedula(String cedula);

    Optional<UsuarioFenix> findByCedulaAndTipo(String cedula,Integer tipo);

    Optional<UsuarioFenix> findByNombresAndCorreoAndTipo(String nombres,String correo,Integer tipo);

    Optional<List<UsuarioFenix>> findByTipo(Integer tipo);

}
