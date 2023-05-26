package com.api.ppp.back.services;

import com.api.ppp.back.models.SolicitudEmpresa;

import java.util.List;

public interface SolicitudEmpresaService extends BaseService<SolicitudEmpresa, Integer> {

    List<SolicitudEmpresa> listarPorEstadoEnviado();

    List<SolicitudEmpresa> listarPorEstadoAceptadoo();

}
