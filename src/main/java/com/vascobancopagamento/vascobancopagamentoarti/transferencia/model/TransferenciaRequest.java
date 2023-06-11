package com.vascobancopagamento.vascobancopagamentoarti.transferencia.model;

import java.math.BigDecimal;

public class TransferenciaRequest {
    private Integer idConta;
    private Integer userIdOrigem;
    private Integer userIdDestino;
    private BigDecimal valor;

    public TransferenciaRequest() {
    }

    public TransferenciaRequest(Integer idConta, Integer userIdOrigem, Integer userIdDestino, BigDecimal valor) {
        this.idConta = idConta;
        this.userIdOrigem = userIdOrigem;
        this.userIdDestino = userIdDestino;
        this.valor = valor;
    }


    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getUserIdOrigem() {
        return userIdOrigem;
    }

    public void setUserIdOrigem(Integer userIdOrigem) {
        this.userIdOrigem = userIdOrigem;
    }

    public Integer getUserIdDestino() {
        return userIdDestino;
    }

    public void setUserIdDestino(Integer userIdDestino) {
        this.userIdDestino = userIdDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
