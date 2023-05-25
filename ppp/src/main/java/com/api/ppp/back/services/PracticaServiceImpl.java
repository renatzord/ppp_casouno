package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.PracticaRepository;
import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.models.TutorInstituto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticaServiceImpl extends BaseServiceImpl<Practica, Integer> implements PracticaService {

    @Autowired
    private PracticaRepository repository;

    public PracticaServiceImpl(BaseRepository<Practica, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Practica> findByTutorInstitutoUsuarioId(Integer id) {
        return repository.findByTutorInstitutoUsuarioId(id);
    }

    @Override
    public List<Practica> findByTutorEmpresarialUsuarioId(Integer id) {
        return repository.findByTutorEmpresarialUsuarioId(id);
    }

    @Override
    public List<Practica> practicaxDocente(TutorInstituto tutorInstituto) {
        return repository.findByTutorInstituto(tutorInstituto).orElse(null);
    }

    @Override
    public Practica practicaxEstudiante(Estudiante estudiante) {
        return repository.findByEstudiante(estudiante).orElse(null);
    }

    @Override
    public List<Practica> practicaxEmpresa(TutorEmpresarial tutorInstituto) {
        return repository.findByTutorEmpresarial(tutorInstituto).orElse(null);
    }

    @Override
    public List<Practica> practicaxEstudianteUsuario(Integer id) {
        return repository.findByEstudianteUsuarioId(id);
    }

}
