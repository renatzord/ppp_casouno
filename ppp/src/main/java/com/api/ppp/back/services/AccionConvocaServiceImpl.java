package com.api.ppp.back.services;

import com.api.ppp.back.daos.AccionConvocaRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.models.AccionConvoca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccionConvocaServiceImpl extends BaseServiceImpl<AccionConvoca, Integer> implements AccionConvocaService {

    @Autowired
    private AccionConvocaRepository repository;

    public AccionConvocaServiceImpl(BaseRepository<AccionConvoca, Integer> baseRepository) {
        super(baseRepository);
    }

}
