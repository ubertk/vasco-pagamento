package com.vascobancopagamento.vascobancopagamentoarti.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoConta;

@Repository
public interface ExtratoContaRepository extends JpaRepository<ExtratoConta, Integer> {

}