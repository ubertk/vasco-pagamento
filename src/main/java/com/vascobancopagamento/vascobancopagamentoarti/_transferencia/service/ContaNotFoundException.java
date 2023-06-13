package com.vascobancopagamento.vascobancopagamentoarti.transferencia.service;

public class ContaNotFoundException extends RuntimeException {
    public ContaNotFoundException(String message) {
        super(message);
    }
}