package com.vascobank.pagamentotransferencia.transferencia.controller;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    private TransferenciaService transferenciaService;
    private ContaService contaService;

    public TransferenciaController(TransferenciaService transferenciaService, ContaService contaService) {
        this.transferenciaService = transferenciaService;
        this.contaService = contaService;
    }

    public ResponseEntity<Transferencia> realizarTransferencia(@RequestBody TransferenciaDTO transferenciaDTO) {
        Conta contaOrigem = contaService.obterContaPorNumero(transferenciaDTO.getContaOrigemNumero());
        Conta contaDestino = contaService.obterContaPorNumero(transferenciaDTO.getContaDestinoNumero());

        if (contaOrigem == null || contaDestino == null) {
            return ResponseEntity.badRequest().build();
        }

        Transferencia transferencia = transferenciaService.realizarTransferencia(contaOrigem, contaDestino, transferenciaDTO.getValor());

        return ResponseEntity.status(HttpStatus.CREATED).body(transferencia);
    }

}