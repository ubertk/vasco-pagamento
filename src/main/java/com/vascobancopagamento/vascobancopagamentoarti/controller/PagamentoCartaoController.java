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
import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoBoleto;
import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoCartao;
import com.vascobancopagamento.vascobancopagamentoarti.service.ExtratoBoletoService;
import com.vascobancopagamento.vascobancopagamentoarti.service.ExtratoCartaoService;
import com.vascobancopagamento.vascobancopagamentoarti.shared.model.SaldoDTO;

@RestController
@RequestMapping(value = "/pagCartao")
public class PagamentoCartaoController {
    @Autowired
    private ExtratoCartaoService extratoCartaoService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{idCartaoCredito}")
    public ResponseEntity<?> checarCartaoDeCredito(@PathVariable String idCartaoCredito){
        try{
            CartaoCredito cartaoCredito = CartaoCredito.cartaoCreditoAleatorio();
            cartaoCredito.setIdCartaoCredito(idCartaoCredito);
            return ResponseEntity.status(HttpStatus.OK).body(cartaoCredito);
        }catch (Exception e) {
            // enviar log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\": \"500 \", message\": \"Nao foi possivel achar o cartão\"}");
        }
    }
    @PostMapping("/pagamento")
    public ResponseEntity<?> pagarComCartaoDeCredito(@RequestBody ExtratoCartao cartaoCredito){
        try{
            SaldoDTO saldo = restTemplate.getForObject("http://localhost:8080/contaCorrente/saldo/{idConta}",
                    SaldoDTO.class,
                    cartaoCredito.getIdConta());
            if (cartaoCredito.getLimiteAux >= ExtratoCartao.valorTotal){
                restTemplate.put("http://localhost:8080/contaCorrente/saldo", cartaoCredito, null);
         
            }
            else
            {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\": \"400 \", message\": \"Limite insuficiente\"}");
            }

        }catch (Exception e) {
            // enviar log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\": \"500 \", message\": \"Nao foi possivel concluir\"}");
        }
    }
}
