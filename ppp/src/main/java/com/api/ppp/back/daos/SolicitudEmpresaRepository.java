package com.api.ppp.back.daos;

import com.api.ppp.back.models.SolicitudEmpresa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudEmpresaRepository extends BaseRepository<SolicitudEmpresa, Integer> {

    List<SolicitudEmpresa> findByEstado(Integer integer);

}
