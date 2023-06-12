package com.vascobancopagamento.vascobancopagamentoarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.vascobancopagamento.vascobancopagamentoarti.model.DTO.ComprovanteTransferenciaDTO;
import com.vascobancopagamento.vascobancopagamentoarti.model.DTO.transferenciaDTO;
import com.vascobancopagamento.vascobancopagamentoarti.service.ExtratoContaService;
import com.vascobancopagamento.vascobancopagamentoarti.shared.model.ContaDTO;
import com.vascobancopagamento.vascobancopagamentoarti.shared.model.SaldoDTO;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    private ExtratoContaService extratoContaService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/pix")
    public ResponseEntity<?> realizarTransferencia(@RequestBody transferenciaDTO transferencia) {
        try {
            ContaDTO conta = restTemplate.getForObject("http://localhost:8080/contaCorrente/pix/{chave}",
                    ContaDTO.class,
                    transferencia.getChavePix());

            if (conta == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"status\": \"404 \", message\": \"Conta com chave nao encontrado\"}");

            restTemplate.put("http://localhost:8080/contaCorrente/saldo/{idConta}",
                    new SaldoDTO(conta.getId(), conta.getSaldo() + transferencia.getValor()), conta.getId());
            ComprovanteTransferenciaDTO comprovante = new ComprovanteTransferenciaDTO(LocalDateTime.now().toString(),
                    new Random().toString(), conta.getNome(), conta.getCpf(), "Vasco Bank");

            return ResponseEntity.status(HttpStatus.OK)
                    .body(extratoContaService.extratoTransferencia(conta.getId(), comprovante));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar a transferência.");
        }
    }
}