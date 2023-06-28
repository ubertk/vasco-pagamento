package com.vascobancopagamento.vascobancopagamentoarti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ExtratoCartao {
    private Integer idConta;
    private Integer idCartao;
    private String nome;
    private String dataVencimento;
    private String cvv;
    private double limite;
    private double limiteAux;
    private boolean eligivelAumentoLimite;
    private boolean virtual;
    private int quantidadeParcelas;
    private double taxaJuros;
    private double valorDaCompra;//valor antes de aplicar juros ou caso não tenha juros na compra
    private double valorTotal;//valor após aplicar juros

}