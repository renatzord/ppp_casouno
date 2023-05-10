package com.api.ppp.back.services;

import com.api.ppp.back.models.Actividad;
import com.api.ppp.back.models.SolicitudEmpresa;

import java.util.List;

public interface ActividadService extends BaseService<Actividad, Integer> {

    public List<Actividad> buscarxSolicitud(SolicitudEmpresa solicitudEmpresa);

}
