package com.example.lab8_gtics_20251_20203266.service;

import com.example.lab8_gtics_20251_20203266.dto.BlogPostDTO;
import com.example.lab8_gtics_20251_20203266.entity.BlogPost;
import com.example.lab8_gtics_20251_20203266.exception.ResourceNotFoundException;
import com.example.lab8_gtics_20251_20203266.repository.BlogPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepository blogPostRepository;
    private final ModelMapper modelMapper;

    public BlogPostServiceImpl(BlogPostRepository blogPostRepository, ModelMapper modelMapper) {
        this.blogPostRepository = blogPostRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BlogPostDTO> findAllPosts() {
        return blogPostRepository.findAll().stream()
                .map(post -> modelMapper.map(post, BlogPostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BlogPostDTO findPostById(Long id) {
        BlogPost post = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post no encontrado con id: " + id));
        return modelMapper.map(post, BlogPostDTO.class);
    }

    @Override
    public BlogPostDTO savePost(BlogPostDTO postDTO) {
        BlogPost post = modelMapper.map(postDTO, BlogPost.class);
        BlogPost savedPost = blogPostRepository.save(post);
        return modelMapper.map(savedPost, BlogPostDTO.class);
    }

    @Override
    public BlogPostDTO updatePost(Long id, BlogPostDTO postDTO) {
        BlogPost existingPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post no encontrado con id: " + id));
        modelMapper.map(postDTO, existingPost);
        BlogPost updatedPost = blogPostRepository.save(existingPost);
        return modelMapper.map(updatedPost, BlogPostDTO.class);
    }

    @Override
    public void deletePost(Long id) {
        if (!blogPostRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post no encontrado con id: " + id);
        }
        blogPostRepository.deleteById(id);
    }
}