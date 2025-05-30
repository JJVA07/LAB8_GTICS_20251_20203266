package com.example.lab8_gtics_20251_20203266.service;

import com.example.lab8_gtics_20251_20203266.dto.BlogPostDTO;
import java.util.List;

public interface BlogPostService {
    List<BlogPostDTO> findAllPosts();
    BlogPostDTO findPostById(Long id);
    BlogPostDTO savePost(BlogPostDTO postDTO);
    BlogPostDTO updatePost(Long id, BlogPostDTO postDTO);
    void deletePost(Long id);
}