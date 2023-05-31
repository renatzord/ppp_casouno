package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.VisitaRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.Visita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitaServiceImpl extends BaseServiceImpl<Visita, Integer> implements VisitaService {

    @Autowired
    private VisitaRepository repository;

    public VisitaServiceImpl(BaseRepository<Visita, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Visita findUltimaVisitaByPractica(Integer id) {
        Optional<Visita> visita = repository.findUltimaVisitaByPractica(id);
        if (visita.isEmpty()) {
            throw new ResourceNotFoundException("No hay una visita relacionada con Practica ID: " + id);
        }
        return visita.get();
    }
}
