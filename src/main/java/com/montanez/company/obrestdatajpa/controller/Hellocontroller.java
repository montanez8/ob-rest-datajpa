package com.montanez.company.obrestdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
    @GetMapping("/saludo")
   public String holamundo(){
       return "Hola mundo que tal";
   }
}
