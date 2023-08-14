package com.spring.codeblog.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate; // Import LocalDate

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post")//nome da tabela do banco de dados


public class Post {
    
    //atributos do banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 100, nullable = false)
    private String autor;

    @Column(length = 180, nullable = false)
    private String titulo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    @Column(length = 255, nullable = true)
    @Lob
    private String texto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    
    
    }
