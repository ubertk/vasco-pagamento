package com.vascobancopagamento.vascobancopagamentoarti.transferencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vascobancopagamento.vascobancopagamentoarti.transferencia.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    List<Transferencia> findAllByContaOrigemOrContaDestino(Integer idConta, Integer idConta2);
    
}