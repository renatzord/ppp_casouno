package com.api.ppp.back.services;

import com.api.ppp.back.daos.ActividadRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.models.Actividad;
import com.api.ppp.back.models.SolicitudEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadServiceImpl extends BaseServiceImpl<Actividad, Integer> implements ActividadService {

    @Autowired
    private ActividadRepository repository;

    public ActividadServiceImpl(BaseRepository<Actividad, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Actividad> buscarxSolicitud(SolicitudEmpresa solicitudEmpresa) {
        return (List<Actividad>) repository.findAllBySolicitudEmpresa(solicitudEmpresa).orElse(null);
    }
}
