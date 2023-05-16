package com.api.ppp.fenix.fservices;

import com.api.ppp.fenix.fmodels.UsuarioFenix;

import java.util.List;

public interface UsuarioFenixService {

    public List<UsuarioFenix> findAll();

    public UsuarioFenix findByCedula(String cedula);

    public UsuarioFenix findByCedulaEstudiante(String cedula);

    public UsuarioFenix findByNombresAndCorreoAndTipo(String nombres, String correo,Integer tipo);

    public UsuarioFenix findByNombresAndCorreoAlumnos(String nombres, String correo);

    public List<UsuarioFenix> findByDocentes();

}
