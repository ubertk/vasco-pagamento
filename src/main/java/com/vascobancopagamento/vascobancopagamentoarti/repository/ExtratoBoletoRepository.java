package com.vascobancopagamento.vascobancopagamentoarti.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vascobancopagamento.vascobancopagamentoarti.model.ExtratoBoleto;

@Repository
public interface ExtratoBoletoRepository extends JpaRepository<ExtratoBoleto, Integer> {

}