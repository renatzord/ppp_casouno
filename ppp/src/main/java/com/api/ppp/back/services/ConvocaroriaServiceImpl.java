package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ConvocatoriaRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.Convocatoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Convocatoria> listConvocatorias() {
        return repository.findAllConvocatorias();
    }

    @Override
    public Optional<Convocatoria> findBySolicitudEmpresaId(Integer id) {
        Optional<Convocatoria> convocatorias = repository.findLatestBySolicitudEmpresaId(id);
        if (convocatorias.isEmpty()) {
            throw new ResourceNotFoundException("No hay registros relacionados en Convocatoria con la SolicitudEmpresa_ID: " + id);
        }
        return convocatorias;
    }

}
