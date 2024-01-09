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
        a.setDescricao("Arroz branco");
        a.setPreco(new BigDecimal(15.00));
        produtos_repository.save(a);

        var b = new Produto();
        b.setDescricao("Macarrão espaguete");
        b.setPreco(new BigDecimal( 4.00));
        produtos_repository.save(b);

        var c = new Produto();
        c.setDescricao("Leite integral");
        c.setPreco(new BigDecimal(3.50));
        produtos_repository.save(c);

        var d = new Produto();
        d.setDescricao("Ovos");
        d.setPreco(new BigDecimal(6.00));
        produtos_repository.save(d);

        var e = new Produto();
        e.setDescricao("Peito de frango");
        e.setPreco(new BigDecimal(13.00));
        produtos_repository.save(e);

        var f = new Produto();
        f.setDescricao("Maçãs");
        f.setPreco(new BigDecimal(4.50));
        produtos_repository.save(f);

         var g = new Produto();
        g.setDescricao("Sabonete líquido");
        g.setPreco(new BigDecimal(8.00));
        produtos_repository.save(g);

        var h = new Produto();
        h.setDescricao("Detergente");
        h.setPreco(new BigDecimal(2.50));
        produtos_repository.save(h);

        var i = new Produto();
        i.setDescricao("Shampoo");
        i.setPreco(new BigDecimal(12.50));
        produtos_repository.save(i);

        var j = new Produto();
        j.setDescricao("Papel higiênico");
        j.setPreco(new BigDecimal(6.00));
        produtos_repository.save(j);
       }

       if(clientes_repository.count() == 0){
        var a = new Cliente();
        a.setNome("Ana Silva");
        a.setCnpj("42.537.400/0001-80");
        clientes_repository.save(a);

        var b = new Cliente();
        b.setNome("Carlos Mendes");
        b.setCnpj("28.394.131/0001-10");
        clientes_repository.save(b);

        var c = new Cliente();
        c.setNome("Sofia Oliveira");
        c.setCnpj("06.095.609/0001-78");
        clientes_repository.save(c);

        var d = new Cliente();
        d.setNome("João Santos");
        d.setCnpj("13.703.240/0001-02");
        clientes_repository.save(d);

        var e = new Cliente();
        e.setNome("Marina Fernandes");
        e.setCnpj("87.283.842/0001-86");
        clientes_repository.save(e);

        var f = new Cliente();
        f.setNome("Pedro Rodrigues");
        f.setCnpj("68.742.019/0001-47");
        clientes_repository.save(f);

        var g = new Cliente();
        g.setNome("Laura Costas");
        g.setCnpj("21.868.949/0001-88");
        clientes_repository.save(g);

        var h = new Cliente();
        h.setNome("Miguel Almeida");
        h.setCnpj("84.602.546/0001-02");
        clientes_repository.save(h);
       }
    }
    
}
