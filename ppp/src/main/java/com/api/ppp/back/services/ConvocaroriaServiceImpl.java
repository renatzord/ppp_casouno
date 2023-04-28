package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ConvocatoriaRepository;
import com.api.ppp.back.models.Convocatoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvocaroriaServiceImpl extends BaseServiceImpl<Convocatoria, Integer> implements ConvocaroriaService {

    @Autowired
    private ConvocatoriaRepository repository;

    public ConvocaroriaServiceImpl(BaseRepository<Convocatoria, Integer> baseRepository) {
        super(baseRepository);
    }

}
