package com.api.ppp.back.services;

import com.api.ppp.back.models.Practica;
import com.api.ppp.back.models.Usuario;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface PracticaService extends BaseService<Practica, Integer> {

    List<Practica> findByTutorInstituto_Usuario(Usuario usuario);

}
