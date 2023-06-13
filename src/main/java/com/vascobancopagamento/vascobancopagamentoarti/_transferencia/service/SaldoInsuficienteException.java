package com.vascobancopagamento.vascobancopagamentoarti._transferencia.service;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
