package com.canex.TestePratico.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canex.TestePratico.domain.entities.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {
   
}
