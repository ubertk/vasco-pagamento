package com.vascobank.pagamentotransferencia.boleto.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Boleto {
    private Long id;

    private String numero;
    private BigDecimal valor;
    private boolean pago;

    private LocalDate dataVencimento;

    private Beneficiario beneficiario;

    private Pagador pagador;

     // Construtores

    public Boleto() {
    }

    public Boleto(String numero, BigDecimal valor, LocalDate dataVencimento, Beneficiario beneficiario, Pagador pagador) {
        this.numero = numero;
        this.valor = valor;
        this.pago = false;
        this.dataVencimento = dataVencimento;
        this.beneficiario = beneficiario;
        this.pagador = pagador;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public boolean isPago() {
        return pago;
    }
    
    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public Beneficiario getBeneficiario() {
        return beneficiario;
    }
    
    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
    
    public Pagador getPagador() {
        return pagador;
    }
    
    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }
}
