package com.vascobancopagamento.vascobancopagamentoarti.transferencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.model.Transferencia;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.model.TransferenciaRequest;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.service.ContaNotFoundException;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.service.SaldoInsuficienteException;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.service.TransferenciaService;
import java.math.BigDecimal;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    private TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<String> realizarTransferencia(@RequestBody TransferenciaRequest transferenciaRequest) {
        try {
            Integer idConta = transferenciaRequest.getIdConta();
            Integer userIdOrigem = transferenciaRequest.getUserIdOrigem();
            Integer userIdDestino = transferenciaRequest.getUserIdDestino();
            BigDecimal valor = transferenciaRequest.getValor();

            Transferencia transferencia = transferenciaService.realizarTransferencia(idConta, userIdOrigem, userIdDestino, valor);

            return ResponseEntity.status(HttpStatus.CREATED).body("Transferência realizada com sucesso. ID da transferência: " + transferencia.getId());
        } catch (ContaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar a transferência.");
        }
    }
}