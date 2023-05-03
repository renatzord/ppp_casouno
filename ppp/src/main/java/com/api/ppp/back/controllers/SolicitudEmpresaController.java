package com.api.ppp.back.controllers;

import com.api.ppp.back.models.SolicitudEmpresa;
import com.api.ppp.back.services.SolicitudEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitudEmpresa")
public class SolicitudEmpresaController {

    @Autowired
    private SolicitudEmpresaService service;

}
