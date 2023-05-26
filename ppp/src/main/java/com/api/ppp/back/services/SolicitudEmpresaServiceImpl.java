package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.SolicitudEmpresaRepository;
import com.api.ppp.back.exception.ResourceNotFoundException;
import com.api.ppp.back.models.SolicitudEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudEmpresaServiceImpl extends BaseServiceImpl<SolicitudEmpresa, Integer> implements SolicitudEmpresaService {

    @Autowired
    private SolicitudEmpresaRepository repository;

    public SolicitudEmpresaServiceImpl(BaseRepository<SolicitudEmpresa, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<SolicitudEmpresa> listarPorEstadoEnviado() {
        List<SolicitudEmpresa> solicitudEmpresas = repository.findByEstado(1);
        if (solicitudEmpresas.isEmpty()) {
            throw new ResourceNotFoundException("Registros no existentes para el estado enviado para SolicitudEmprese (1)");
        }
        return solicitudEmpresas;
    }

    @Override
    public List<SolicitudEmpresa> listarPorEstadoAceptadoo() {
        List<SolicitudEmpresa> solicitudEmpresas = repository.findByEstado(2);
        if (solicitudEmpresas.isEmpty()) {
            throw new ResourceNotFoundException("Registros no existentes para el estado aceptado para SolicitudEmprese (2)");
        }
        return solicitudEmpresas;
    }
}
