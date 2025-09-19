package com.miproyectospring.prueba.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miproyectospring.prueba.entidades.Autor;
import com.miproyectospring.prueba.excepciones.MiExcepcion;
import com.miproyectospring.prueba.repositorios.AutorRepositorio;

import jakarta.transaction.Transactional;

@Service
public class AutorServicio {
    @Autowired
    AutorRepositorio autorRepositorio;
    @Transactional
    public void crearAutor(String nombre)throws MiExcepcion{
        if(nombre ==null || nombre.isEmpty()){
            throw new MiExcepcion("El nombre no debe ser nulo o estar vacío");
        }
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepositorio.save(autor);

    }
    public List<Autor> listarAutores(){
        List<Autor> autores = new ArrayList<>();
        autores = autorRepositorio.findAll();
        return autores;
    }
    public void actualizarAutor(String id, String nombre)throws MiExcepcion{
        if(id == null || id.isEmpty()){
            throw new MiExcepcion("El id no puede ser nulo o estar vacío");
        }
        if(nombre == null || nombre.isEmpty()){
            throw new MiExcepcion("El nombre no puede ser nulo o estar vacío");
        }
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if(respuesta.isPresent()){
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        }
    }
}
