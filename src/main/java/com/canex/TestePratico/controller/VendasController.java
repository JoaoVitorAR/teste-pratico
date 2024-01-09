package com.canex.TestePratico.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.canex.TestePratico.domain.DTO.VendaDTO;
import com.canex.TestePratico.domain.entities.Cliente;
import com.canex.TestePratico.domain.entities.Produto;
import com.canex.TestePratico.domain.entities.Venda;
import com.canex.TestePratico.domain.repository.Clientes;
import com.canex.TestePratico.domain.repository.Produtos;
import com.canex.TestePratico.domain.repository.Vendas;

@Controller
public class VendasController {

    @Autowired private Vendas vendas_repository;
    @Autowired private Clientes clientes_repository;
    @Autowired private Produtos produtos_repository;

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
        mv.addObject("clientes", clientes_repository.findAll());
        mv.addObject("produtos", produtos_repository.findAll());
        return mv;
    }

    @PostMapping("InsertVendas")
    public ModelAndView inserirVendas(Venda venda) {
        ModelAndView mv = new ModelAndView();
            mv.addObject("vendas");
            mv.setViewName("redirect:/listarVendas");
            vendas_repository.save(venda);
        return mv;        
    }

    @GetMapping(value = "/listarVendas")
    public ModelAndView ListVendas(Venda venda){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Vendas/listVendas");
        List<Venda> vendas_list = vendas_repository.findAll();
        List<Cliente> cliente_list = clientes_repository.findAll();
        List<VendaDTO> list_venda = new ArrayList<>();
        vendas_list.stream().forEach(vendas -> {
            VendaDTO apoio = new VendaDTO();
            apoio.id = vendas.getId();
            apoio.data_compra = vendas.getData_compra();
            apoio.total_compra = vendas.getTotal_compra();
            apoio.nome = cliente_list.stream().filter(cliente ->  
                cliente.getId() == vendas.getCliente_id()
            ).findAny().orElse(null).getNome();
            list_venda.add(apoio);
        });
        mv.addObject("listVendas", list_venda);
        return mv;
    }


    @GetMapping("RecuperaValorProdutoPorId")
    public ResponseEntity<BigDecimal> recuperaValorProdutoPorId(Long produtoId) {
        Optional<Produto> produto = produtos_repository.findById(produtoId);
        return ResponseEntity.ok(produto.get().getPreco());
    }
    
}
