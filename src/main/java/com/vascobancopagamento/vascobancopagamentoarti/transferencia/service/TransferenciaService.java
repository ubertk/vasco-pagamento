package com.vascobancopagamento.vascobancopagamentoarti.transferencia.service;

import com.vascobancopagamento.vascobancopagamentoarti.transferencia.model.Conta;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.model.Transferencia;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.repository.TransferenciaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
    public class TransferenciaService {
    private TransferenciaRepository transferenciaRepository;
    private ContaRepository contaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, ContaRepository contaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.contaRepository = contaRepository;
    }

    @Transactional
        public Transferencia realizarTransferencia(Integer idContaOrigem, Integer idContaDestino, Integer userIdDestino, BigDecimal valor) {
                Conta contaOrigem = contaRepository.retornarConta(idContaOrigem)
                        .orElseThrow(() -> new ContaNotFoundException("Conta de origem não encontrada"));

                Conta contaDestino;
                if (userIdDestino != null) {
                    contaDestino = contaRepository.retornarContaChavePix(userIdDestino, idContaDestino);
                } else {
                    contaDestino = contaRepository.retornarConta(idContaDestino);
                }

                if (contaDestino == null) {
                    throw new ContaNotFoundException("Conta de destino não encontrada");
                }

                BigDecimal saldoOrigem = contaOrigem.getSaldo();
                if (saldoOrigem.compareTo(valor) < 0) {
                    throw new SaldoInsuficienteException("Saldo insuficiente na conta de origem");
                }

                // Atualiza o saldo das contas
                BigDecimal novoSaldoOrigem = saldoOrigem.subtract(valor);
                BigDecimal novoSaldoDestino = contaDestino.getSaldo().add(valor);
                contaOrigem.setSaldo(novoSaldoOrigem);
                contaDestino.setSaldo(novoSaldoDestino);

                // Salva as alterações das contas
                contaRepository.save(contaOrigem);
                contaRepository.save(contaDestino);

                Transferencia transferencia = new Transferencia();
                transferencia.setContaOrigem(idContaOrigem);
                transferencia.setContaDestino(contaDestino.getId());
                transferencia.setValor(valor);
                transferencia.setData(LocalDateTime.now());

                return transferenciaRepository.save(transferencia);
            }
        }