package com.vascobank.pagamentotransferencia.boleto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/boletos")
public class BoletoController {
    private boletoService boletoService;
    
    public BoletoController(boletoService boletoService) {
        this.boletoService = boletoService;
    }

    public ResponseEntity<Boleto> criarBoleto(@RequestBody BoletoRequestDTO boletoRequest) {
        Boleto boleto = boletoService.criarBoleto(
            boletoRequest.getNumero(),
            boletoRequest.getValor(),
            boletoRequest.getDataVencimento(),
            boletoRequest.getBeneficiario(),
            boletoRequest.getPagador()
        );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(boleto);
    }

    public ResponseEntity<String> pagarBoleto(@PathVariable Long id) {
        boolean pagamentoEfetuado = boletoService.efetuarPagamento(id);
        
        if (pagamentoEfetuado) {
            return ResponseEntity.ok("Boleto pago com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível efetuar o pagamento do boleto.");
        }
    }
}
