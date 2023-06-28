package com.vascobancopagamento.vascobancopagamentoarti.model;

import com.vascobancopagamento.vascobancopagamentoarti.model.enums.MESES;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compra {
    private Integer id;
    private Integer idCartao;
    private double valor;
    private String dataCompra;
    private MESES mesCompra;
    private String local;
    private int parcelas;

}
