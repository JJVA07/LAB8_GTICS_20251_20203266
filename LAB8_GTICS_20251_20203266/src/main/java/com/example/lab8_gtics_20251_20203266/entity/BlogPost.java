package com.example.lab8_gtics_20251_20203266.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog_post")
@Getter
@Setter
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Lob
    @Column(nullable = false)
    private String contenido;

    private String autor;
    private String categoria;

    @CreationTimestamp
    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;
}