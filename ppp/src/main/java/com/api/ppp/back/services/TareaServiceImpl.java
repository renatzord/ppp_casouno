package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.TareaRepository;
import com.api.ppp.back.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServiceImpl extends BaseServiceImpl<Tarea, Integer> implements TareaService {

    @Autowired
    private TareaRepository repository;

    public TareaServiceImpl(BaseRepository<Tarea, Integer> baseRepository) {
        super(baseRepository);
    }

}
