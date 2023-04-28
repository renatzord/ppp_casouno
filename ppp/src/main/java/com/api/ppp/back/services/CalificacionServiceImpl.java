package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.CalificacionRepository;
import com.api.ppp.back.models.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionServiceImpl extends BaseServiceImpl<Calificacion, Integer> implements CalificacionService {

    @Autowired
    private CalificacionRepository repository;

    public CalificacionServiceImpl(BaseRepository<Calificacion, Integer> baseRepository) {
        super(baseRepository);
    }

}
