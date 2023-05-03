package com.api.ppp.back.controllers;

import com.api.ppp.back.services.SolicitudEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitudEstudiante")
public class SolicitudEstudianteController {

    @Autowired
    private SolicitudEstudianteService service;

}
