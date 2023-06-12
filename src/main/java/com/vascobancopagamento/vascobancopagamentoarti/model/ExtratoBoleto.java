package com.vascobancopagamento.vascobancopagamentoarti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExtratoBoleto {
    private Integer idConta;
    private Integer id;
    private String numero;
    private double valorCobrado;
    private double valorTotal;
    private double juros;
    private boolean pago;
    private String dataVencimento;
    private String beneficiario;
    private String cpfcnpj;
    private String instrucoes;
    private String codigoBarras;
    private String datapagamento;
    
}
