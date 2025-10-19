package com.miproyectospring.prueba.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MiControlador {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
    
}
