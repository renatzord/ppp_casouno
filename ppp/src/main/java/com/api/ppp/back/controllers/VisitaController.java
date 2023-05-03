package com.api.ppp.back.controllers;

import com.api.ppp.back.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private VisitaService service;

}
