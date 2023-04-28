package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.ConvenioRepository;
import com.api.ppp.back.models.Convenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvenioServiceImpl extends BaseServiceImpl<Convenio, Integer> implements ConvenioService {

    @Autowired
    private ConvenioRepository repository;

    public ConvenioServiceImpl(BaseRepository<Convenio, Integer> baseRepository) {
        super(baseRepository);
    }

}
