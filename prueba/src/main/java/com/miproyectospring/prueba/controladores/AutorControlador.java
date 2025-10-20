package com.miproyectospring.prueba.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miproyectospring.prueba.entidades.Autor;
import com.miproyectospring.prueba.excepciones.MiExcepcion;
import com.miproyectospring.prueba.servicios.AutorServicio;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/autor")
public class AutorControlador {
    
    @Autowired
    AutorServicio autorServicio;
    
    @GetMapping("/registrar")
    public String registrar() {
        return "autor_form.html";
    }
    @PostMapping("/registro")
    public String registro(@RequestParam String autorNombre) {
       
        
        try {
            autorServicio.crearAutor(autorNombre);
        } catch (MiExcepcion e) {
            
            e.printStackTrace();
        }

        return "autor_form.html";
    }
    
    
}
