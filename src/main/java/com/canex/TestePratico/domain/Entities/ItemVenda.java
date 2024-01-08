package com.canex.TestePratico.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "itemvenda")
public class ItemVenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "venda_id")
    private Long venda_id;

    @Column(name = "produto_id")
    private Long produto_id;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "total_produto")
    private BigDecimal total_produto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(Long venda_id) {
        this.venda_id = venda_id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal_produto() {
        return total_produto;
    }

    public void setTotal_produto(BigDecimal total_produto) {
        this.total_produto = total_produto;
    }

    
}
