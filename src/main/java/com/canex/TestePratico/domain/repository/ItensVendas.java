package com.canex.TestePratico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canex.TestePratico.domain.entities.ItemVenda;

public interface ItensVendas extends JpaRepository<ItemVenda, Long> {
    
}
