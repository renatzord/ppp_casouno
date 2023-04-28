package com.api.ppp.back.services;

import com.api.ppp.back.daos.AccionRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.models.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadServiceImpl extends BaseServiceImpl<Actividad, Integer> implements ActividadService {

    @Autowired
    private AccionRepository repository;

    public ActividadServiceImpl(BaseRepository<Actividad, Integer> baseRepository) {
        super(baseRepository);
    }

}
