package com.canex.TestePratico.domain.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "venda")
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemSeq")
    private long itemSeq;

    @ManyToOne
    @JoinColumn(name = "produto_id") // Chave estrangeira para a categoria
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;
}
