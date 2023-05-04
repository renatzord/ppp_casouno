package com.api.ppp.fenix.fservices;

import com.api.ppp.fenix.fmodels.UsuarioFenix;

import java.util.List;

public interface UsuarioFenixService {

    public List<UsuarioFenix> findAll();

    public UsuarioFenix findByCedula(String cedula);



}
