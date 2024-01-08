package com.canex.TestePratico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.canex.TestePratico.domain.entities.ItemVenda;
import com.canex.TestePratico.domain.entities.Venda;
import com.canex.TestePratico.domain.repository.Clientes;
import com.canex.TestePratico.domain.repository.ItensVendas;
import com.canex.TestePratico.domain.repository.Produtos;
import com.canex.TestePratico.domain.repository.Vendas;

@Controller
public class VendasController {

    @Autowired private Vendas vendas_repository;
    @Autowired private Clientes clientes_repository;
    @Autowired private Produtos produtos_repository;
    @Autowired private ItensVendas itensVendas_repository;

    @GetMapping(value = "/inserirVendas")
    public ModelAndView InsertVendas(Venda venda){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Vendas/formVendas");
        mv.addObject("vendas", new Venda());
        Long ultimaVenda = (long) 1;
        if (vendas_repository.getUltimoId() != null){
            ultimaVenda = vendas_repository.getUltimoId() + 1;
        }
        mv.addObject("ultimaVenda", ultimaVenda);
        mv.addObject("listagemVendas", vendas_repository.findAll());
        mv.addObject("clientes", clientes_repository.findAll());
        mv.addObject("produtos", produtos_repository.findAll());
        mv.addObject("itensVendidos", itensVendas_repository.findAll());
        return mv;
    }

    /*@PostMapping("InsertVendas")
    public ModelAndView inserirVendas(@Valid Venda venda, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("Vendas/formVendas");
            mv.addObject("vendas");
        } else {
             mv.setViewName("redirect:/listarVendas");
            vendas_repository.save(venda);
        }     
        return mv;        
    }*/

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
        mv.addObject("clientes", clientes_repository.findAll());
        return mv;
    }

    @PostMapping("InsertProdutos")
    public ModelAndView inserirProdutos(ItemVenda itensVendas) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Vendas/formVendas");
        itensVendas_repository.save(itensVendas);   
        return mv;        
    }
}
