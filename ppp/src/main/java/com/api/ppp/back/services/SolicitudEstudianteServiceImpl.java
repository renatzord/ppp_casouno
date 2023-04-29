package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.SolicitudEstudianteRepository;
import com.api.ppp.back.models.SolicitudEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudEstudianteServiceImpl extends BaseServiceImpl<SolicitudEstudiante, Integer> implements SolicitudEstudianteService {

    @Autowired
    private SolicitudEstudianteRepository repository;

    public SolicitudEstudianteServiceImpl(BaseRepository<SolicitudEstudiante, Integer> baseRepository) {
        super(baseRepository);
    }

}
