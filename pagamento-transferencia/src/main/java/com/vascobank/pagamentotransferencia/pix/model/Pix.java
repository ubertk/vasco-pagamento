package com.vascobank.pagamentotransferencia.pix.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pix {
    private Long id;
    
    private String chave;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    
    private Pagador pagador;
    
    private Beneficiario beneficiario;
    
    // Construtores
    
    public Pix() {
    }
    
    public Pix(String chave, BigDecimal valor, LocalDateTime dataHora, Pagador pagador, Beneficiario beneficiario) {
        this.chave = chave;
        this.valor = valor;
        this.dataHora = dataHora;
        this.pagador = pagador;
        this.beneficiario = beneficiario;
    }
    
    // Getters e Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Pagador getPagador() {
        return pagador;
    }

    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}
