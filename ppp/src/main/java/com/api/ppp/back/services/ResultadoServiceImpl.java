package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ResultadoRepository;
import com.api.ppp.back.models.Resultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultadoServiceImpl extends BaseServiceImpl<Resultado, Integer> implements ResultadoService {

    @Autowired
    private ResultadoRepository repository;

    public ResultadoServiceImpl(BaseRepository<Resultado, Integer> baseRepository) {
        super(baseRepository);
    }

}
