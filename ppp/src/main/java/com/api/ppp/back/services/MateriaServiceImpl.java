package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.MateriaRepository;
import com.api.ppp.back.models.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl extends BaseServiceImpl<Materia, Integer> implements MateriaService {

    @Autowired
    private MateriaRepository repository;

    public MateriaServiceImpl(BaseRepository<Materia, Integer> baseRepository) {
        super(baseRepository);
    }

}
