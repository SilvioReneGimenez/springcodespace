package com.miproyectospring.prueba.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miproyectospring.prueba.entidades.Editorial;
import com.miproyectospring.prueba.excepciones.MiExcepcion;
import com.miproyectospring.prueba.repositorios.EditorialRepositorio;

import jakarta.transaction.Transactional;

@Service
public class EditorialServicio {
    @Autowired
    EditorialRepositorio editorialRepositorio;
    @Transactional
    public void crearEditorial(String nombre)throws MiExcepcion{
        if(nombre == null || nombre.isEmpty()){
            throw new MiExcepcion("El nombre no puede ser nulo o estar vacío");
        }
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }
    public List<Editorial> listarEditoriales(){
        List<Editorial> editoriales = new ArrayList<>();
        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }
    public void actualizarEditorial(String id, String nombre)throws MiExcepcion{
        if(id == null || id.isEmpty()){
            throw new MiExcepcion("El id no puede ser nulo o estar vacío");
        }
        if(nombre == null || nombre.isEmpty()){
            throw new MiExcepcion("El nombre no puede ser nulo o estar vacío");
        }
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if(respuesta.isPresent()){
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }

    }
}
