package com.cityofCrime.cityofCrime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/*")
    public String get404(){
        return "404";
    }

    @RequestMapping("/register")
    public String getRegister(){
        return "register";
    }

    @RequestMapping("/home")
    public String getHome(){
        return "index";
    }
}
