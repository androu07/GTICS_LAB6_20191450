package com.example.lab6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/dispositivos")
    public String index() {
        return "redirect:/dispositivos";
    }
}

