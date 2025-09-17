package com.miproyectospring.prueba.java.com.miproyectospring.prueba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiController {
    @GetMapping
    private String mostrarMensaje(){
        return "prueba de rest controller..aborigen.";
    }
}
