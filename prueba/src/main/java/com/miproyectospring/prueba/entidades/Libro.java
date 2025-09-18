package com.miproyectospring.prueba.entidades;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Libro {
    @Id
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Editorial editorial;
}
