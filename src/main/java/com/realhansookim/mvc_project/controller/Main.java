package com.realhansookim.mvc_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {
    @GetMapping("/")
    public String getMain(){
    return "main";
    }

}
