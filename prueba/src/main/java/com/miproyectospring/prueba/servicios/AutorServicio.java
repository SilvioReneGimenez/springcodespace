package com.miproyectospring.prueba.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miproyectospring.prueba.entidades.Autor;
import com.miproyectospring.prueba.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
    @Autowired
    AutorRepositorio autorRepositorio;
    public void crearAutor(String nombre){
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepositorio.save(autor);

    }
}
