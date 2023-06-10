package com.vascobancopagamento.vascobancopagamentoarti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Boleto {
    private Integer id;
    private String numero;
    private double valorCobrado;
    private double valorTotal;
    private double juros;
    private boolean pago;
    private String dataVencimento;
    private String localPagamento;
    private String cedente;
    private String agenciaCedente;
    private String instrucoes;
    private String codigoBarras;

    public static Boleto boletoAleatorio() {
        return new Boleto(1, "9378727", 50.00, 52.00, 2.00, false, "29/06/2018",
                "Pagavel em qualquer banco ate a data de vencimento", "Jose da Silva",
                "023/323", "Nao receber apos vencimento", "2380472830472384743434444");

    }

    public boolean getPago(){
        return this.pago;
    }

}
