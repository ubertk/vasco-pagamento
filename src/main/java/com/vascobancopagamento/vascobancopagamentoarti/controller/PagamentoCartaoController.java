package com.vascobancopagamento.vascobancopagamentoarti.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vascobancopagamento.vascobancopagamentoarti.model.Boleto;
import com.vascobancopagamento.vascobancopagamentoarti.model.CartaoCredito;
import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoBoleto;
import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoCartao;
import com.vascobancopagamento.vascobancopagamentoarti.model.Fatura;
import com.vascobancopagamento.vascobancopagamentoarti.service.ExtratoBoletoService;
import com.vascobancopagamento.vascobancopagamentoarti.service.ExtratoCartaoService;
import com.vascobancopagamento.vascobancopagamentoarti.shared.model.ContaDTO;
import com.vascobancopagamento.vascobancopagamentoarti.shared.model.SaldoDTO;

@RestController
@RequestMapping(value = "/pagCartao")
public class PagamentoCartaoController {
    @Autowired
    private ExtratoCartaoService extratoCartaoService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{idCartaoCredito}")
    public ResponseEntity<?> checarCartaoDeCredito(@PathVariable Integer idCartaoCredito) {
        try {
            CartaoCredito cartaoCredito = CartaoCredito.cartaoCreditoAleatorio();
            cartaoCredito.setId(idCartaoCredito);
            return ResponseEntity.status(HttpStatus.OK).body(cartaoCredito);
        } catch (Exception e) {
            // enviar log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\": \"500 \", message\": \"Nao foi possivel achar o cartão\"}");
        }
    }

    @PostMapping("/pagamento/{idFatura}")
    public ResponseEntity<?> pagarCartaoDeCredito(@PathVariable Integer idFatura,
            @RequestBody CartaoCredito cartaoCredito) {
        try {
            ContaDTO conta = restTemplate.getForObject("http://localhost:8080/contaCorrente/{idConta}",
                    ContaDTO.class,
                    cartaoCredito.getIdConta());

            Fatura fatura = restTemplate.getForObject("http://localhost:8081/fatura/{idFatura}",
                    Fatura.class,
                    idFatura);
            if (conta == null || fatura == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\": \"400 \", message\": \"Error ao encontrar faturas e contas\"}");

            if (conta.getSaldo() >= fatura.getValorTotal()) {
                fatura.setPaga(true);
                conta.setSaldo(conta.getSaldo() - fatura.getValorTotal());
                restTemplate.put("http://localhost:8080/contaCorrente/{idConta}", conta, conta.getId());
                restTemplate.put("http://localhost:8081/fatura/{idCartao}", fatura, fatura.getIdCartao());
                ExtratoCartao extratoCartao = new ExtratoCartao(fatura.getValorTotal(), conta.getNome(),
                        conta.getAgencia(), conta.getNumeroComDigito());

                return ResponseEntity.status(HttpStatus.OK)
                        .body(extratoCartaoService.salvarExtrato(extratoCartao));
                // enviar log
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\": \"400 \", message\": \"Limite insuficiente\"}");
            }

        } catch (Exception e) {
            // enviar log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"status\": \"500 \", message\": \"Nao foi possivel concluir\"}");
        }
    }
}
