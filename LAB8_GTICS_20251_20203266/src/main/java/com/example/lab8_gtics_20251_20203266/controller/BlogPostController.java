package com.example.lab8_gtics_20251_20203266.controller;


import com.example.lab8_gtics_20251_20203266.entity.BlogPost;
import com.example.lab8_gtics_20251_20203266.repository.BlogPostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/posts")
public class BlogPostController {
    private final BlogPostRepository blogPostRepository;

    public BlogPostController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", blogPostRepository.findAll());
        return "posts/list";
    }

    @GetMapping("/nuevo")
    public String createForm(Model model) {
        model.addAttribute("post", new BlogPost());
        return "posts/form";
    }

    @PostMapping("/guardar")
    public String savePost(@ModelAttribute BlogPost post) {
        if(post.getFechaPublicacion() == null) {
            post.setFechaPublicacion(LocalDateTime.now());
        }
        blogPostRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/editar/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostRepository.findById(id).orElseThrow());
        return "posts/form";
    }

    @GetMapping("/eliminar/{id}")
    public String deletePost(@PathVariable Long id) {
        blogPostRepository.deleteById(id);
        return "redirect:/posts";
    }
}