package com.api.ppp.back.services;

import com.api.ppp.back.daos.AspectoRepository;
import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.models.Aspecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AspectoServiceImpl extends BaseServiceImpl<Aspecto, Integer> implements AspectoService {

    @Autowired
    private AspectoRepository repository;

    public AspectoServiceImpl(BaseRepository<Aspecto, Integer> baseRepository) {
        super(baseRepository);
    }

}
