package com.miproyectospring.prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miproyectospring.prueba.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial,String> {
    
}
