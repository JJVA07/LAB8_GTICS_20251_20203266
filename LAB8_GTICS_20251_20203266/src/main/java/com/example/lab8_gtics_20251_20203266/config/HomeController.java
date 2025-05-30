package com.example.lab8_gtics_20251_20203266.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";  // Renderiza index.html
    }
}
