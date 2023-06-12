package com.vascobancopagamento.vascobancopagamentoarti.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExtratoConta {
    Integer idConta;
    String dataHoraPagamento;
    String idTransicao;
    String recebeuNome;
    String recebeuCpf;
    String recebeuBanco;
    
}
