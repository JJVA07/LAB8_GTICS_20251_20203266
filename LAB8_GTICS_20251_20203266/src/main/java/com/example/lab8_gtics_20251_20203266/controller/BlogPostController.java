package com.example.lab8_gtics_20251_20203266.controller;

import com.example.lab8_gtics_20251_20203266.dto.BlogPostDTO;
import com.example.lab8_gtics_20251_20203266.service.BlogPostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class BlogPostController {
    private final BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", blogPostService.findAllPosts());
        return "posts/list";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new BlogPostDTO());
        return "posts/form";
    }

    @PostMapping("/nuevo")
    public String createPost(@Valid @ModelAttribute("post") BlogPostDTO postDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "posts/form";
        }
        blogPostService.savePost(postDTO);
        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostService.findPostById(id));
        return "posts/view";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostService.findPostById(id));
        return "posts/form";
    }

    @PostMapping("/editar/{id}")
    public String updatePost(@PathVariable Long id,
                             @Valid @ModelAttribute("post") BlogPostDTO postDTO,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "posts/form";
        }
        blogPostService.updatePost(id, postDTO);
        return "redirect:/posts";
    }

    @GetMapping("/eliminar/{id}")
    public String deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return "redirect:/posts";
    }
}