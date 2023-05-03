package com.api.ppp.back.controllers;

import com.api.ppp.back.services.SemanaActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semanaActividad")
public class SemanaActividadController {

    @Autowired
    private SemanaActividadService service;

}
