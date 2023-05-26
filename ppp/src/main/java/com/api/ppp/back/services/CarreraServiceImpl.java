package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.CarreraRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarreraServiceImpl extends BaseServiceImpl<Carrera, Integer> implements CarreraService {

    @Autowired
    private CarreraRepository repository;

    public CarreraServiceImpl(BaseRepository<Carrera, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public boolean findByIdCarrera(Integer idCarrera) {
        return (repository.findByIdCarrera(idCarrera).orElse(null)==null);
    }

    @Override
    public Carrera buscarPorIdCarrera(Integer idCarrera) {
        Optional<Carrera> carrera = repository.findByIdCarrera(idCarrera);
        if (carrera.isEmpty()) {
            throw new ResourceNotFoundException("Carrera no encontrado para el idCarrera: " + idCarrera);
        }
        return carrera.get();
    }

}
