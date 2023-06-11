package com.vascobancopagamento.vascobancopagamentoarti.transferencia.service;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
