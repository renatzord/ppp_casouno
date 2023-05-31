package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ConvenioRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.Convenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioServiceImpl extends BaseServiceImpl<Convenio, Integer> implements ConvenioService {

    @Autowired
    private ConvenioRepository repository;

    public ConvenioServiceImpl(BaseRepository<Convenio, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Convenio> busrcarPorEmpresa(Integer id) {
        return repository.findByEmpresaId(id);
    }

    @Override
    public Convenio findLatestByEmpresaId(Integer id) {
        Optional<Convenio> convenio = repository.findLatestByEmpresaId(id);
        if (convenio.isEmpty()) {
            throw new ResourceNotFoundException("No hay registros relacionados de Convenio con empresa_ID: " + id);
        }
        return convenio.get();
    }

    @Override
    public Convenio findLatestConvenio() {
        Optional<Convenio> convenio = repository.findLatestConvenio();
        if (convenio.isEmpty()) {
            throw new ResourceNotFoundException("No hay registros");
        }
        return convenio.get();
    }

}
