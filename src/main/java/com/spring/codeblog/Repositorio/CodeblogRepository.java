package com.spring.codeblog.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.codeblog.Models.Post;


public interface CodeblogRepository extends JpaRepository<Post, Long>{
    
}
