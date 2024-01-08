package com.canex.TestePratico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.canex.TestePratico.domain.entities.Venda;

@Repository
public interface Vendas extends JpaRepository<Venda, Long> {
    
    @Query( value = "select max(id) from venda",nativeQuery = true)
    Long getUltimoId();
}
