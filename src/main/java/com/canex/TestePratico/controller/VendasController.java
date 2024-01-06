package com.canex.TestePratico.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.canex.TestePratico.domain.entities.Venda;
import com.canex.TestePratico.domain.repository.Clientes;
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
        mv.addObject("vendasRealizadas", vendas_repository.count());
        mv.addObject("clientesCadastrados", vendas_repository.findAll());
        return mv;
    }

    @PostMapping("InsertVendas")
    public ModelAndView inserirVendas(Venda venda) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/listarVendas");
        vendas_repository.save(venda);
        return mv;        
    }

    @GetMapping(value = "/listarVendas")
    public ModelAndView ListVendas(Venda venda){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Vendas/listVendas");
        mv.addObject("listagemVendas", vendas_repository.findAll());
        return mv;
    }
}
