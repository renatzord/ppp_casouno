package com.api.ppp.back.controllers;

import com.api.ppp.back.services.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resultado")
public class ResultadoController {

    @Autowired
    private ResultadoService service;


}
