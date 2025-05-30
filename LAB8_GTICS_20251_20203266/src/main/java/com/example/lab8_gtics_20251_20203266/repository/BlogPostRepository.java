package com.example.lab8_gtics_20251_20203266.repository;

import com.example.lab8_gtics_20251_20203266.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}