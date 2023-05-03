package com.api.ppp.back.controllers;

import com.api.ppp.back.models.TutorEmpresarial;
import com.api.ppp.back.services.TutorEmpresarialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutorEmpresa")
public class TutorEmpresarialController {

    @Autowired
    private TutorEmpresarialService service;

}
