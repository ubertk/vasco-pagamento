
package com.vascobancopagamento.vascobancopagamentoarti.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContaDTO {
   
    private Integer id;
    private Integer idUser;
    private String nome;
    private String primeiroNome;
    private String agencia;
    private String numero;
    private Integer digito;
    private String numeroComDigito;
    private String cpf;
    private String profissao;
    private boolean elegivelCredito;
    private double saldo;
    private String ChavePix;

}
