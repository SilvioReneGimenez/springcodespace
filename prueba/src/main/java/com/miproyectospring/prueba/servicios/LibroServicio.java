package com.miproyectospring.prueba.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miproyectospring.prueba.entidades.*;
import com.miproyectospring.prueba.repositorios.*;
@Service
public class LibroServicio {
    @Autowired
    LibroRepositorio libroRepositorio;
    @Autowired
    AutorRepositorio autorRepositorio;
    @Autowired
    EditorialRepositorio editorialRepositorio;


    public void crearLibro(Long isbn,String titulo,Integer ejemplares,String idAutor, String idEditorial ){
        
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
}
