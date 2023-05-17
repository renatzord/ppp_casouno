package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ConvocatoriaRepository;
import com.api.ppp.back.models.Convocatoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ConvocaroriaServiceImpl extends BaseServiceImpl<Convocatoria, Integer> implements ConvocaroriaService {

    @Autowired
    private ConvocatoriaRepository repository;

    public ConvocaroriaServiceImpl(BaseRepository<Convocatoria, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Convocatoria> convocatoriaActivas(Integer car_id)
    {
        return (List<Convocatoria>) repository.convocatoriasActivasxCarrera(car_id).orElse(null);
    }

}
