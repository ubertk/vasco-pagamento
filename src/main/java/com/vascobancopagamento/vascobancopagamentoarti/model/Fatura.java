package com.vascobancopagamento.vascobancopagamentoarti.model;

import java.util.List;

import com.vascobancopagamento.vascobancopagamentoarti.model.enums.MESES;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fatura {

    private Integer id;
    private Integer idCartao;
    private double valorTotal;
    private String dataVencimento;
    private MESES mesVencimento;
    private boolean paga;
    private List<Compra> compras;

}
