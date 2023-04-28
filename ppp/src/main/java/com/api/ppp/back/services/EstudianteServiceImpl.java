package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.EstudianteRepository;
import com.api.ppp.back.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl extends BaseServiceImpl<Estudiante, Integer> implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public EstudianteServiceImpl(BaseRepository<Estudiante, Integer> baseRepository) {
        super(baseRepository);
    }

}
