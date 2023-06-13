package com.vascobancopagamento.vascobancopagamentoarti.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class transferenciaDTO {
    String chavePix;
    double valor;
    
}
