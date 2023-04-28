package com.api.ppp.back.services;

import com.api.ppp.back.daos.AccionRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.models.Accion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AccionServiceImpl extends BaseServiceImpl<Accion, Integer> implements AccionService {

    @Autowired
    private AccionRepository repository;

    public AccionServiceImpl(BaseRepository<Accion, Integer> baseRepository) {
        super(baseRepository);
    }

}
