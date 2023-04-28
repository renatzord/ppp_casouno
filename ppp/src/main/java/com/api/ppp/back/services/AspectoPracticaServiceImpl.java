package com.api.ppp.back.services;

import com.api.ppp.back.daos.AspectoPracticaRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.models.AspectoPractica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AspectoPracticaServiceImpl extends BaseServiceImpl<AspectoPractica, Integer> implements AspectoPracticaService {

    @Autowired
    private AspectoPracticaRepository repository;

    public AspectoPracticaServiceImpl(BaseRepository<AspectoPractica, Integer> baseRepository) {
        super(baseRepository);
    }

}
