package com.example.lab6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/openLoginWindow")
    public String loginWindow(){
        return "loginWindow";
    }
}
