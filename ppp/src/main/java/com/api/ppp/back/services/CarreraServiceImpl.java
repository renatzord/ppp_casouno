package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.CarreraRepository;
import com.api.ppp.back.models.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServiceImpl extends BaseServiceImpl<Carrera, Integer> implements CarreraService {

    @Autowired
    private CarreraRepository repository;

    public CarreraServiceImpl(BaseRepository<Carrera, Integer> baseRepository) {
        super(baseRepository);
    }

}
