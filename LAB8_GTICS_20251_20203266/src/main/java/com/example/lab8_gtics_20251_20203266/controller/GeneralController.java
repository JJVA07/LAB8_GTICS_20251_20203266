package com.example.lab8_gtics_20251_20203266.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/")
    public String mostrarPaginaIndex() {
        return "posts/list"; // Devuelve el nombre del archivo HTML
    }
}
