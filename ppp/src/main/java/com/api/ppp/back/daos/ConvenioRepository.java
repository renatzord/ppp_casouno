package com.api.ppp.back.daos;

import com.api.ppp.back.models.Convenio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvenioRepository extends BaseRepository<Convenio,Integer> {

    List<Convenio> findByEmpresaId(Integer id);

}
