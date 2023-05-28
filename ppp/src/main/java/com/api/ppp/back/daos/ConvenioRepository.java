package com.api.ppp.back.daos;

import com.api.ppp.back.models.Convenio;
import com.api.ppp.back.models.Convocatoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConvenioRepository extends BaseRepository<Convenio,Integer> {

    List<Convenio> findByEmpresaId(Integer id);

    @Query("SELECT c FROM Convenio c WHERE c.empresa.id = :id AND c.id = (SELECT MAX(c2.id) FROM Convenio c2 WHERE c2.empresa.id = :id)")
    Optional<Convenio> findLatestByEmpresaId(Integer id);

    @Query("SELECT c FROM Convenio c WHERE c.id = (SELECT MAX(c2.id) FROM Convenio c2)")
    Optional<Convenio> findLatestConvenio();

}
