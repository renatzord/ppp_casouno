package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.CalificacionRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImpl extends BaseServiceImpl<Calificacion, Integer> implements CalificacionService {

    @Autowired
    private CalificacionRepository repository;

    public CalificacionServiceImpl(BaseRepository<Calificacion, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Calificacion> findByPracticaId(Integer id) {
        List<Calificacion> calificacions = repository.findByPracticaId(id);
        if (calificacions.isEmpty()) {
            throw new ResourceNotFoundException("No hay registros en Calificaion asociados a Practica_ID: " + id);
        }
        return calificacions;
    }

}
