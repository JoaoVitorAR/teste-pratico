package com.canex.TestePratico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canex.TestePratico.domain.Entities.Venda;

public interface Vendas extends JpaRepository<Venda, Long> {

    //@Query(value = "select id, createdAt, cliente_id, total from ")
}
