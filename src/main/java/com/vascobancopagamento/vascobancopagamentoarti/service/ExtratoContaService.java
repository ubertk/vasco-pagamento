package com.vascobancopagamento.vascobancopagamentoarti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoConta;
import com.vascobancopagamento.vascobancopagamentoarti.model.DTO.ComprovanteTransferenciaDTO;
import com.vascobancopagamento.vascobancopagamentoarti.repository.ExtratoContaRepository;

@Service
public class ExtratoContaService {

    @Autowired
    private ExtratoContaRepository extratoContaRepository;

    public ExtratoConta extratoTransferencia(Integer idConta, ComprovanteTransferenciaDTO transferencia){
       return extratoContaRepository.save( new ExtratoConta(idConta, transferencia.getDataHoraPagamento(), transferencia.getIdTransicao(),transferencia.getRecebeuNome(), transferencia.getRecebeuCpf(), transferencia.getRecebeuBanco()));

    }
}
