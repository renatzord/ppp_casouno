package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ResultadoMateriaRepository;
import com.api.ppp.back.models.ResultadoMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultadoMateriaServiceImpl extends BaseServiceImpl<ResultadoMateria, Integer> implements ResultadoMateriaService {

    @Autowired
    private ResultadoMateriaRepository repository;

    public ResultadoMateriaServiceImpl(BaseRepository<ResultadoMateria, Integer> baseRepository) {
        super(baseRepository);
    }

}
