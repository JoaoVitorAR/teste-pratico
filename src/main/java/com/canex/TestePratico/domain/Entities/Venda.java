package com.canex.TestePratico.domain.entities;

import java.math.BigDecimal;
import java.sql.Date;

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
    @Column(name = "num_item")
    private long num_item;

    @ManyToOne
    @JoinColumn(name = "produto_id") 
    private Produto produto_id;

    @Column(name = "cliente_id")
    private Long cliente_id;

    @Column(name = "data_compra")
    @CreationTimestamp
    private Date data_compra;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Column(name = "total_produto")
    private BigDecimal total_produto;

    @Column(name = "total_compra")
    private BigDecimal total_compra;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNum_item() {
        return num_item;
    }

    public void setNum_item(long num_item) {
        this.num_item = num_item;
    }

    public Produto getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Produto produto_id) {
        this.produto_id = produto_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
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

    public BigDecimal getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(BigDecimal total_compra) {
        this.total_compra = total_compra;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    


    
}
