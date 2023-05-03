package com.api.ppp.back.controllers;

import com.api.ppp.back.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService service;

}
