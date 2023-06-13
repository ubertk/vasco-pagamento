package com.vascobancopagamento.vascobancopagamentoarti.transferencia.model;

import java.math.BigDecimal;

public class Conta {
    private Integer id;
    private Integer userId;
    private BigDecimal saldo;
    private String chavePix;

    public Conta() {
    }

    public Conta(Integer userId, BigDecimal saldo, String chavePix) {
        this.userId = userId;
        this.saldo = saldo;
        this.chavePix = chavePix;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
