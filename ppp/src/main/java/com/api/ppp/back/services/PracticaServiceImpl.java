package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.PracticaRepository;
import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticaServiceImpl extends BaseServiceImpl<Practica, Integer> implements PracticaService {

    @Autowired
    private PracticaRepository repository;

    public PracticaServiceImpl(BaseRepository<Practica, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Practica> findByTutorInstitutoUsuarioId(Integer id) {
        return repository.findByTutorInstitutoUsuarioId(id);
    }

}
