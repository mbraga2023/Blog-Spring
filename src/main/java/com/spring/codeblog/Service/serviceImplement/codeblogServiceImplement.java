package com.spring.codeblog.Service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.spring.codeblog.Models.Post;
import com.spring.codeblog.Repositorio.CodeblogRepository;
import com.spring.codeblog.Service.CodeblogService;
import org.springframework.data.domain.Pageable;


@Service 
//Spring stereotype = fala pro Spring que esta classe que sera usada
public class codeblogServiceImplement implements CodeblogService {
    @Autowired
    CodeblogRepository codeblogRepository; // ponto de injecao

    @Override
    public List<Post> findAll() {
        return codeblogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return codeblogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeblogRepository.save(post);
    }
    
    @Override
    public void delete(Post post) {
        codeblogRepository.delete(post);
    }
    @Override
    public Page<Post> findPaginated(Pageable pageable) {
        return codeblogRepository.findAll(pageable);
    }

}