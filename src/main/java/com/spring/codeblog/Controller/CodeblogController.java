package com.spring.codeblog.Controller;

import java.util.List;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import com.spring.codeblog.Models.Post;
import com.spring.codeblog.Service.CodeblogService;

@Controller // Indicates that this class is a Spring MVC controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService; // Inject the CodeblogService

    // Handles HTTP GET requests for the "/posts" URL
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        // Create a ModelAndView with the view name "posts"

        // Call the findAll() method from CodeblogService to retrieve a list of posts
        List<Post> posts = codeblogService.findAll();

        // Add the list of posts as an attribute to the ModelAndView
        mv.addObject("posts", posts);

        return mv;
        // Return the ModelAndView, which will be processed by the view resolver
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        // Create a ModelAndView with the view name "posts"

        Post post = codeblogService.findById(id);

        // Add the list of posts as an attribute to the ModelAndView
        mv.addObject("post", post);

        return mv;
        // Return the ModelAndView, which will be processed by the view resolver
    }
    @GetMapping("/newpost")
    public String novo(){
        return "/postForm";
    }

    @PostMapping("/newpost")
    public String savePost(Post post) {
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }

    @ControllerAdvice
    public class CustomErrorController {

        @ExceptionHandler(Exception.class)
        public String handleException() {
            return "error"; // Return the name of your custom error view
        }
    }

   // Controller method for editing a post
@GetMapping("/editpost/{id}")
public String editPost(@PathVariable("id") long id, Model model) {
    // Retrieve the post with the given ID
    Post post = codeblogService.findById(id);
    
    // Add the retrieved post to the model to populate the form
    model.addAttribute("post", post);
    
    // Return the view for editing the post
    return "editpost";
}

// Controller method for updating a post
@PostMapping("/updatepost")
public String updatePost(@ModelAttribute("post") Post post) {
    // Set the 'data' property of the post to the current date
    post.setData(LocalDate.now());
    
    // Save the updated post
    codeblogService.save(post);
    
    // Redirect to the list of posts after the update
    return "redirect:/posts";
}

// Controller method for handling post deletion
@GetMapping("/deletepost/{id}")
    public String deletePost(@PathVariable("id") long id) {
        Post post = codeblogService.findById(id);
        if (post != null) {
            codeblogService.delete(post);
        }
        return "redirect:/admin";
    }
    
@GetMapping("/admin")
public String admin(Model model) {
    List<Post> posts = codeblogService.findAll();
    model.addAttribute("posts", posts);
    return "Admin/index"; // Make sure the view path is correct
}
}
