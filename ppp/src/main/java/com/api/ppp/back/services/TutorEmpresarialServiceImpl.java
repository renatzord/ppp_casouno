package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.TutorEmpresarialRepository;
import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorEmpresarialServiceImpl extends  BaseServiceImpl<TutorEmpresarial, Integer> implements TutorEmpresarialService {

    @Autowired
    private TutorEmpresarialRepository repository;

    public TutorEmpresarialServiceImpl(BaseRepository<TutorEmpresarial, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public TutorEmpresarial tutorxUsuario(Usuario usuario) {
        return (TutorEmpresarial) repository.findByUsuario(usuario).orElse(null);
    }

}
