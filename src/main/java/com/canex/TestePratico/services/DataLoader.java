package com.canex.TestePratico.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.canex.TestePratico.domain.entities.Cliente;
import com.canex.TestePratico.domain.entities.Produto;
import com.canex.TestePratico.domain.repository.Clientes;
import com.canex.TestePratico.domain.repository.Produtos;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Produtos produtos_repository;
    
    @Autowired
    private Clientes clientes_repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       if(produtos_repository.count() == 0){
        var a = new Produto();
        a.setDescricao("Prod A");
        a.setPreco(new BigDecimal(3.20));
        produtos_repository.save(a);

        var b = new Produto();
        b.setDescricao("Prod B");
        b.setPreco(new BigDecimal(1.30));
        produtos_repository.save(b);

        var c = new Produto();
        c.setDescricao("Prod C");
        c.setPreco(new BigDecimal(5.80));
        produtos_repository.save(c);
       }

       if(clientes_repository.count() ==0){
        var a = new Cliente();
        a.setNome("Cliente A");
        a.setCnpj("42.537.400/0001-80");
        clientes_repository.save(a);

        var b = new Cliente();
        b.setNome("Cliente A");
        b.setCnpj("28.394.131/0001-10");
        clientes_repository.save(b);

        var c = new Cliente();
        c.setNome("Cliente C");
        c.setCnpj("06.095.609/0001-78");
        clientes_repository.save(c);
       }
    }
    
}
