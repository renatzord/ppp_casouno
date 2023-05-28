package com.api.ppp.back.services;

import com.api.ppp.back.models.Convenio;

import java.util.List;
import java.util.Optional;

public interface ConvenioService extends BaseService<Convenio, Integer> {

    List<Convenio> busrcarPorEmpresa(Integer id);

    Convenio findLatestByEmpresaId(Integer id);

    Convenio findLatestConvenio();

}
