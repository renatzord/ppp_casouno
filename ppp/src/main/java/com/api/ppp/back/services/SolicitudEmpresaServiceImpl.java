package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.SolicitudEmpresaRepository;
import com.api.ppp.back.models.SolicitudEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudEmpresaServiceImpl extends BaseServiceImpl<SolicitudEmpresa, Integer> implements SolicitudEmpresaService {

    @Autowired
    private SolicitudEmpresaRepository repository;

    public SolicitudEmpresaServiceImpl(BaseRepository<SolicitudEmpresa, Integer> baseRepository) {
        super(baseRepository);
    }

}
