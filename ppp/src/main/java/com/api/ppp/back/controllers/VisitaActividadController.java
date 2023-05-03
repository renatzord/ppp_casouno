package com.api.ppp.back.controllers;

import com.api.ppp.back.models.VisitaActividad;
import com.api.ppp.back.services.VisitaActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitaActividad")
public class VisitaActividadController {

    @Autowired
    private VisitaActividadService service;

}
