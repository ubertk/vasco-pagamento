package com.vascobancopagamento.vascobancopagamentoarti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartaoCredito {
    private Integer id;
    private Integer idConta;
    private String nome;
    private String numero;
    private String dataVencimento;
    private String cvv;
    private double limiteFixo;
    private double limiteAux;
    private boolean eligivelAumentoLimite;
    private boolean virtual;
    private double taxaJuros;

    public static CartaoCredito cartaoCreditoAleatorio() {
        return new CartaoCredito(123, 321, "Cartão Teste", "7",
                "20/06/2023", "133", 1000.00, 1000.00, true, true, 0.9);
    }
}
