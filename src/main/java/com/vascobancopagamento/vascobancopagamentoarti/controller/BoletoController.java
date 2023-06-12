package com.vascobancopagamento.vascobancopagamentoarti.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vascobancopagamento.vascobancopagamentoarti.model.Boleto;
import com.vascobancopagamento.vascobancopagamentoarti.shared.model.ContaDTO;
import com.vascobancopagamento.vascobancopagamentoarti.shared.model.SaldoDTO;

@RestController
@RequestMapping(value = "/boleto")
public class BoletoController {

    // @Autowired
    // private boletoService boletoService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{codigoBarras}")
    public ResponseEntity<?> retornarBoletoPorCodigoBarras(@PathVariable String codigoBarras) {

        try {
            Boleto boleto = Boleto.boletoAleatorio();
            boleto.setCodigoBarras(codigoBarras);
            return ResponseEntity.status(HttpStatus.OK).body(boleto);
        } catch (Exception e) {
            // enviar log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\": \"500 \", message\": \"Nao foi possivel cadastrar\"}");
        }

    }

    @PostMapping("/{idConta}")
    public ResponseEntity<?> pagarBoleto(@RequestBody Boleto boleto, @PathVariable Integer idConta) {
        try {
            SaldoDTO saldo = restTemplate.getForObject("http://localhost:8080/contaCorrente/saldo/{idConta}", SaldoDTO.class,
                    idConta);

            if (saldo.getValor() >= boleto.getValorTotal()) {

                if (!boleto.getPago()) {
                    boleto.setPago(true);

                    restTemplate.put("http://localhost:8080/contaCorrente/saldo",
                            new SaldoDTO(idConta ,saldo.getValor() - boleto.getValorTotal()), idConta);

                  //todo gerar extrato
                    return ResponseEntity.status(HttpStatus.OK).body(boleto);
                } else {
                    return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                            .body("{\"status\": \"208 \", message\": \"Boleto já pago\"}");
                }

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\": \"400 \", message\": \"Saldo insuficiente\"}");
            }
        } catch (Exception e) {
            // enviar log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\": \"500 \", message\": \"Nao foi possivel concluir\"}");
        }

    }
}
