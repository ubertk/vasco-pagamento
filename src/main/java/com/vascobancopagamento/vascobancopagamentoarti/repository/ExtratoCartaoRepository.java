package com.vascobancopagamento.vascobancopagamentoarti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoCartao;

@Repository
public interface ExtratoCartaoRepository  extends JpaRepository<ExtratoCartao, Integer>{
    
}
