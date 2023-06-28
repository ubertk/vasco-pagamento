package com.vascobancopagamento.vascobancopagamentoarti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoCartao;
import com.vascobancopagamento.vascobancopagamentoarti.repository.ExtratoCartaoRepository;

@Service
public class ExtratoCartaoService {
    @Autowired
    private ExtratoCartaoRepository extratoBoletoRepository;

    public ExtratoCartao salvarExtrato(ExtratoCartao extrato){
        return extratoBoletoRepository.save(extrato);
    }
}
