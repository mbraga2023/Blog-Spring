package com.spring.codeblog.Service;

import com.spring.codeblog.Models.Post;
import java.util.List;

public interface CodeblogService {
    List<Post> findAll();

    Post findById(long id);

    Post save(Post post);

    void delete(Post post);
}
