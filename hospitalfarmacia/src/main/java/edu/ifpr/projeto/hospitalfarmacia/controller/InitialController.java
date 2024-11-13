package edu.ifpr.projeto.hospitalfarmacia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InitialController {
    
    @GetMapping
    public String initialUrl(){
        return "Hello World";
    }
}
