package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.TutorInstitutoRepository;
import com.api.ppp.back.models.TutorInstituto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorInstitutoServiceImpl extends BaseServiceImpl<TutorInstituto, Integer> implements TutorInstitutoService {

    @Autowired
    private TutorInstitutoRepository repository;

    public TutorInstitutoServiceImpl(BaseRepository<TutorInstituto, Integer> baseRepository) {
        super(baseRepository);
    }

}
