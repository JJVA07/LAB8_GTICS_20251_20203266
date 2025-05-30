package com.example.lab8_gtics_20251_20203266.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogPostDTO {
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String contenido;

    private String autor;
    private LocalDateTime fechaPublicacion;
    private String categoria;
}