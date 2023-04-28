package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.SemanaActividadRepository;
import com.api.ppp.back.models.SemanaActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SemanaActividadServiceImpl extends BaseServiceImpl<SemanaActividad, Integer> implements SemanaActividadService {

    @Autowired
    private SemanaActividadRepository repository;

    public SemanaActividadServiceImpl(BaseRepository<SemanaActividad, Integer> baseRepository) {
        super(baseRepository);
    }

}
