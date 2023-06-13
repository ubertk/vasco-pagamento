package com.vascobancopagamento.vascobancopagamentoarti._transferencia.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transferencia {
    private Integer id;
    private Integer idConta;
    private Integer contaOrigem;
    private Integer contaDestino;
    private BigDecimal valor;
    private LocalDateTime data;
    

    public Transferencia() {
        this.data = LocalDateTime.now();
    }

    public Transferencia(Integer idConta, Integer contaOrigem, Integer contaDestino, BigDecimal valor) {
        this.idConta = idConta;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Integer contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Integer getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Integer contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
