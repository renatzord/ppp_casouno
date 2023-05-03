package com.api.ppp.back.controllers;

import com.api.ppp.back.models.ObjetivoMateria;
import com.api.ppp.back.services.ObjetivoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/objetivoMateria")
@RestController
public class ObjetivoMateriaController {

    @Autowired
    private ObjetivoMateriaService service;

}
