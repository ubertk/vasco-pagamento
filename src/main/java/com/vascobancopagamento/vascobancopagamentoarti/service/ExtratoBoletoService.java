package com.vascobancopagamento.vascobancopagamentoarti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoBoleto;
import com.vascobancopagamento.vascobancopagamentoarti.repository.ExtratoBoletoRepository;

@Service
public class ExtratoBoletoService {

    @Autowired
    private ExtratoBoletoRepository extratoBoletoRepository;

    public ExtratoBoleto extratoBoleto(ExtratoBoleto boleto) {
        return extratoBoletoRepository.save(new ExtratoBoleto(boleto.getIdConta(), boleto.getId(), boleto.getNumero(),
                boleto.getValorCobrado(), boleto.getValorTotal(), boleto.getJuros(), boleto.isPago(),
                boleto.getDataVencimento(), boleto.getBeneficiario(), boleto.getCpfcnpj(), boleto.getInstrucoes(),
                boleto.getCodigoBarras(), boleto.getDatapagamento()));

    }
}
