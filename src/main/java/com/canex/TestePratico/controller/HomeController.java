package com.canex.TestePratico.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {
       
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("msg", "Mensagem vindo do controller");
        return mv;
    }
    
}
