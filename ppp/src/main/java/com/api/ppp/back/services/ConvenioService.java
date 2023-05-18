package com.api.ppp.back.services;

import com.api.ppp.back.models.Convenio;

import java.util.List;

public interface ConvenioService extends BaseService<Convenio, Integer> {

    List<Convenio> busrcarPorEmpresa(Integer id);

}
