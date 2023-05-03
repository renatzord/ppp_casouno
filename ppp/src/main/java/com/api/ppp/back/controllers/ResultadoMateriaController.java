package com.api.ppp.back.controllers;

import com.api.ppp.back.services.ResultadoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resultadoMateria")
public class ResultadoMateriaController {

    @Autowired
    private ResultadoMateriaService service;

}
