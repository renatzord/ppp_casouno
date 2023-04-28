package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.EmpresaRepository;
import com.api.ppp.back.models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpresaServiceImpl extends BaseServiceImpl<Empresa, Integer> implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public EmpresaServiceImpl(BaseRepository<Empresa, Integer> baseRepository) {
        super(baseRepository);
    }

}
