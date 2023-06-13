package com.vascobancopagamento.vascobancopagamentoarti._transferencia.service;

public class ContaNotFoundException extends RuntimeException {
    public ContaNotFoundException(String message) {
        super(message);
    }
}