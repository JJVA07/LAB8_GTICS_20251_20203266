package com.example.lab8_gtics_20251_20203266.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class BlogPostDTO {
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String contenido;

    private String autor;
    private String categoria;
    private LocalDateTime fechaPublicacion;
}