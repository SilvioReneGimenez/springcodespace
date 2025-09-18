package com.miproyectospring.prueba.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miproyectospring.prueba.entidades.Editorial;
import com.miproyectospring.prueba.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {
    @Autowired
    EditorialRepositorio editorialRepositorio;
    public void crearEditorial(String nombre){
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }
}
