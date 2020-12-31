package com.example.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/owners")
public class OwnerController {

    @GetMapping(path = {"/", "/index.html", "/index", ""})
    public String listOwners(){
        return "owners/index";
    }
}
