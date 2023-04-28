package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ObjetivoMateriaRepository;
import com.api.ppp.back.models.ObjetivoMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetivoMateriaServiceImpl extends BaseServiceImpl<ObjetivoMateria, Integer> implements ObjetivoMateriaService {

    @Autowired
    private ObjetivoMateriaRepository repository;

    public ObjetivoMateriaServiceImpl(BaseRepository<ObjetivoMateria, Integer> baseRepository) {
        super(baseRepository);
    }

}
