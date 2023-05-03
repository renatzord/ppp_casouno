package com.api.ppp.back.controllers;

import com.api.ppp.back.services.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practica")
public class PracticaController {

    @Autowired
    private PracticaService service;

}
