package com.api.ppp.back.controllers;

import com.api.ppp.back.services.TutorEmpresarialService;
import com.api.ppp.back.services.TutorInstitutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutorInstituto")
public class TutorInstitutoController {

    @Autowired
    private TutorInstitutoService service;

}
