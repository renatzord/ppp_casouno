package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ResultadoMateriaRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.ResultadoMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoMateriaServiceImpl extends BaseServiceImpl<ResultadoMateria, Integer> implements ResultadoMateriaService {

    @Autowired
    private ResultadoMateriaRepository repository;

    public ResultadoMateriaServiceImpl(BaseRepository<ResultadoMateria, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ResultadoMateria> findByCarreraId(Integer id) {
        List<ResultadoMateria> resultadoMaterias = repository.findByCarreraId(id);
        if (resultadoMaterias.isEmpty()) {
            throw new ResourceNotFoundException("No hay registros asociados a ResMate por el carrera ID:" + id);
        }
        return resultadoMaterias;
    }

}
