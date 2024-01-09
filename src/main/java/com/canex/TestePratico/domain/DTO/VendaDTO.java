package com.canex.TestePratico.domain.DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class VendaDTO {
    
    public long id;
    public String nome;
    public Date data_compra;
    public BigDecimal total_compra;

    public VendaDTO(Long id, String nome, Date data_compra, BigDecimal total_compra) {
        this.id = id;
        this.nome = nome;
        this.data_compra = data_compra;
        this.total_compra = total_compra;
    }

    public VendaDTO(){} 
}
