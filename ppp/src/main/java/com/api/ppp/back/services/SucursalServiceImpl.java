package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.SucursalRepository;
import com.api.ppp.back.models.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl extends BaseServiceImpl<Sucursal, Integer> implements SucursalService {

    @Autowired
    private SucursalRepository repository;

    public SucursalServiceImpl(BaseRepository<Sucursal, Integer> baseRepository) {
        super(baseRepository);
    }

}
