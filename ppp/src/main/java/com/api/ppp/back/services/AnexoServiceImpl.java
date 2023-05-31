package com.api.ppp.back.services;

import com.api.ppp.back.daos.AnexoRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.Anexos;
import com.api.ppp.back.models.Practica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnexoServiceImpl extends BaseServiceImpl<Anexos, Integer> implements AnexoService {

    @Autowired
    private AnexoRepository repository;

    public AnexoServiceImpl(BaseRepository<Anexos, Integer> baseRepository) {
        super(baseRepository);
    }


    @Override
    public Anexos anexoTipo(Integer id, Integer tipo) {
        Optional<Anexos> anexos = repository.findAllByPracticaIdAndTipo(id, tipo);
        if (anexos.isEmpty()) {
            throw new ResourceNotFoundException("No hay registro relacionado con Anexo de Practica ID: " + id +" y tipo: " + tipo);
        }
        return anexos.get();
    }
}
