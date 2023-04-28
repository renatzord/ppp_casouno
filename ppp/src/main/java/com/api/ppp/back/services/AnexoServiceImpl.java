package com.api.ppp.back.services;

import com.api.ppp.back.daos.AnexoRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.models.Anexos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnexoServiceImpl extends BaseServiceImpl<Anexos, Integer> implements AnexoService {

    @Autowired
    private AnexoRepository repository;

    public AnexoServiceImpl(BaseRepository<Anexos, Integer> baseRepository) {
        super(baseRepository);
    }

}
