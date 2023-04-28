package com.api.ppp.back.daos;

import com.api.ppp.back.models.Empresa;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends BaseRepository<Empresa, Integer> {
}
