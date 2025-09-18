package com.miproyectospring.prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.miproyectospring.prueba.entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor,String> {
    
}
