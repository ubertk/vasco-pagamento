package com.vascobancopagamento.vascobancopagamentoarti.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComprovanteTransferenciaDTO {
   String dataHoraPagamento;
   String idTransicao;
   String recebeuNome;
   String recebeuCpf;
   String recebeuBanco;
}
