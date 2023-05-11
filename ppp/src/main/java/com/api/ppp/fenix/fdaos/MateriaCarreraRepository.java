package com.api.ppp.fenix.fdaos;

import com.api.ppp.fenix.fmodels.MateriaCarrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface MateriaCarreraRepository extends CrudRepository<MateriaCarrera,Integer> {

    Optional <List<MateriaCarrera>> findAllByNombreContainingAndCarreraIdAndTipo(String nombre,Integer carreraId ,Integer tipo);

    Optional <List<MateriaCarrera>> findAllByTipo(Integer tipo);

}
