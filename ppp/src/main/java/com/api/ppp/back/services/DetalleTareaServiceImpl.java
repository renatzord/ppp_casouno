package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.DetalleTareaRepository;
import com.api.ppp.back.models.DetalleTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleTareaServiceImpl extends BaseServiceImpl<DetalleTarea, Integer> implements DetalleTareaService {

    @Autowired
    private DetalleTareaRepository repository;

    public DetalleTareaServiceImpl(BaseRepository<DetalleTarea, Integer> baseRepository) {
        super(baseRepository);
    }

}
