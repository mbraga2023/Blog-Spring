package com.spring.codeblog.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate; 
import java.util.*;
import com.spring.codeblog.Models.Post;
import com.spring.codeblog.Repositorio.CodeblogRepository;

//import jakarta.annotation.PostConstruct;

@Component
public class DummyData {
    @Autowired
    CodeblogRepository codeblogRepository;

//@PostConstruct // vai executar com a aplicacao
    public void savePosts() {
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Michell Britto");
        post1.setTitulo("Docker");
        post1.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        post1.setData(LocalDate.now());

        /*Post post2 = new Post();
        post2.setAutor("Michell Britto");
        post2.setTitulo("JAVA");
        post2.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");*/

        /*Post post3 = new Post();
        post3.setAutor("Michell Britto");
        post3.setTitulo("API");
        post3.setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");*/

        postList.add(post1);
        //postList.add(post2);
        //postList.add(post3);

        for (Post post: postList){
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }

}
