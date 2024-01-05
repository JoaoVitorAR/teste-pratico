package com.canex.TestePratico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.canex.TestePratico.domain.Entities.Venda;
import com.canex.TestePratico.domain.repository.Vendas;

@Controller
public class VendasController {

    @Autowired
    private Vendas vendas_repository;

    @GetMapping(value = "/inserirVendas")
    public ModelAndView InsertVendas(Venda venda){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Vendas/formVendas");
        mv.addObject("vendas", new Venda());
        return mv;
    }

    @PostMapping("InsertVendas")
    public ModelAndView inserirVendas(Venda venda) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/Vendas/listVendas");
        vendas_repository.save(venda);
        return mv;        
    }
}
