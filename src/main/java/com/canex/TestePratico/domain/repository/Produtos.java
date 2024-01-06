package com.canex.TestePratico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canex.TestePratico.domain.entities.Produto;

public interface Produtos extends JpaRepository<Produto, Long>{
    
}
