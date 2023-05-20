package com.api.ppp.back.services;

import com.api.ppp.back.models.Estudiante;
import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.models.TutorInstituto;

import java.util.List;

import java.util.List;

public interface PracticaService extends BaseService<Practica, Integer> {

    List<Practica> findByTutorInstitutoUsuarioId(Integer id);

    public List<Practica> practicaxDocente(TutorInstituto tutorInstituto);

    public Practica practicaxEstudiante(Estudiante estudiante);

    List<Practica> practicaxEmpresa(TutorEmpresarial tutorInstituto);

}
