package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.VisitaActividadRepository;
import com.api.ppp.back.models.VisitaActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitaActividadServiceImpl extends BaseServiceImpl<VisitaActividad, Integer> implements VisitaActividadService {

    @Autowired
    private VisitaActividadRepository repository;

    public VisitaActividadServiceImpl(BaseRepository<VisitaActividad, Integer> baseRepository) {
        super(baseRepository);
    }

}
