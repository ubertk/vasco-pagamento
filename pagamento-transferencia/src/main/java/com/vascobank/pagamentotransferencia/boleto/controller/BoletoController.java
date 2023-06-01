package com.vascobank.pagamentotransferencia.boleto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vascobank.pagamentotransferencia.boleto.model.Boleto;

@RestController
@RequestMapping ("/boletos")
public class BoletoController {

         // @Autowired
    // private boletoService boletoService;


    public ResponseEntity<?> criarBoleto(@RequestBody Boleto boletoRequest) {
        // Boleto boleto = boletoService.criarBoleto(
        //     boletoRequest.getNumero(),
        //     boletoRequest.getValor(),
        //     boletoRequest.getDataVencimento(),
        //     boletoRequest.getBeneficiario(),
        //     boletoRequest.getPagador()
        // );
        
        return ResponseEntity.status(HttpStatus.CREATED).body(boletoRequest);
    }

    public ResponseEntity<String> pagarBoleto(@PathVariable Long id) {
       // boolean pagamentoEfetuado = boletoService.efetuarPagamento(id);
        
        // if (pagamentoEfetuado) {
        //     return ResponseEntity.ok("Boleto pago com sucesso.");
        // } else {
        //     return ResponseEntity.badRequest().body("Não foi possível efetuar o pagamento do boleto.");
        // }
        return ResponseEntity.ok("Boleto pago com sucesso.");
    }
}
