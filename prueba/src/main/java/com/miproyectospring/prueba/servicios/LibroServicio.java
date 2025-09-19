package com.miproyectospring.prueba.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miproyectospring.prueba.entidades.*;
import com.miproyectospring.prueba.excepciones.MiExcepcion;
import com.miproyectospring.prueba.repositorios.*;

import jakarta.transaction.Transactional;
@Service
public class LibroServicio {
    @Autowired
    LibroRepositorio libroRepositorio;
    @Autowired
    AutorRepositorio autorRepositorio;
    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn,String titulo,Integer ejemplares,String idAutor, String idEditorial ) throws MiExcepcion{
        validarDatos(isbn, titulo, ejemplares, idAutor, idEditorial);
        Autor autor = autorRepositorio.findById(idAutor).get();
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setFechaAlta(new Date());

        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);

    }

    public List<Libro> listarLibros(){
        List<Libro> libros = new ArrayList<>();
        libros = libroRepositorio.findAll();
        return libros;
    }

    public void actualizarLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExcepcion{
        validarDatos(isbn, titulo, ejemplares, idAutor, idEditorial);
        Optional<Libro> respuesta = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
        
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        if(respuestaAutor.isPresent()){
            autor = respuestaAutor.get();
        }

        if(respuestaEditorial.isPresent()){
            editorial = respuestaEditorial.get();
        }

        if(respuesta.isPresent()){
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);

            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libroRepositorio.save(libro);
        }
    }

    private void validarDatos(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExcepcion{
        if (isbn == null) {
            throw new MiExcepcion("El campo isbn no puede ser nulo");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new MiExcepcion("El campo titulo no puede ser nulo o estar vacío");
        }
        if (ejemplares == null) {
            throw new MiExcepcion("El campo ejemplares no puede ser nulo");
        }
        if (idAutor == null || idAutor.isEmpty()) {
            throw new MiExcepcion("El campo autor no puede ser nulo o estar vacío");
        }
        if (idEditorial == null || idEditorial.isEmpty()) {
            throw new MiExcepcion("El campo editorial no puede ser nulo o estar vacío");
        }
    }
}
