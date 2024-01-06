package com.canex.TestePratico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canex.TestePratico.domain.entities.Venda;

public interface Vendas extends JpaRepository<Venda, Long> {
    
}
