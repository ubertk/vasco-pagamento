package com.vascobank.pagamentotransferencia.transferencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vascobank.pagamentotransferencia.transferencia.model.Transferencia;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
        // @Autowired
    // private TransferenciaService transferenciaService;
    // @Autowired
   // private ContaService contaService;

    public ResponseEntity<Transferencia> realizarTransferencia(@RequestBody Transferencia transferenciaDTO) {
        // Conta contaOrigem = contaService.obterContaPorNumero(transferenciaDTO.getContaOrigemNumero());
        // Conta contaDestino = contaService.obterContaPorNumero(transferenciaDTO.getContaDestinoNumero());

        // if (contaOrigem == null || contaDestino == null) {
        //     return ResponseEntity.badRequest().build();
        // }

        // Transferencia transferencia = transferenciaService.realizarTransferencia(contaOrigem, contaDestino, transferenciaDTO.getValor());

        return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaDTO);
    }

}