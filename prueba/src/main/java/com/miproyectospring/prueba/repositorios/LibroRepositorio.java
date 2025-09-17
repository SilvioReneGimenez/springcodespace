package com.miproyectospring.prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miproyectospring.prueba.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro,Long> {
    @Query("SELECT l FROM Libro l WHERE l.titulo = :tituloLibro")
    public Libro buscarPorTitulo(@Param("titulo") String tituloLibro);
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :autorLibro")
    public Libro buscarPorAutor(@Param("nombre") String autorLibro);
}
