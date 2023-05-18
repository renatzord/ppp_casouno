package com.api.ppp.back.controllers;

import com.api.ppp.back.services.ConvocaroriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    @Autowired
    private ConvocaroriaService service;

    @GetMapping("/noticias")
    public ResponseEntity<?> listarConvocatorias() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(service.listConvocatorias());
    }

}
