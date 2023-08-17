package com.spring.codeblog.Service;

import com.spring.codeblog.Models.Post;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CodeblogService {
    List<Post> findAll();

    Post findById(long id);

    Post save(Post post);

    void delete(Post post);

    Page<Post> findPaginated(Pageable pageable);

}
