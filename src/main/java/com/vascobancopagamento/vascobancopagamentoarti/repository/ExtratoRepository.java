package com.vascobancopagamento.vascobancopagamentoarti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vascobancopagamento.vascobancopagamentoarti.model.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Integer> {
    @Modifying
    @Query(value ="SELECT * FROM EXTRATO WHERE id_conta = :idConta AND dia = :dia", nativeQuery = true)
    public List<Extrato> extratoDia(@Param("idConta") Integer idConta, @Param("dia") Integer dia);

    // @Query("SELECT * FROM EXTRATO s WHERE s.id_conta = ?idConta AND s.ano =
    // ?ano")
    // public List<Extrato> extratoAno(@Param("idConta") Integer
    // idConta,@Param("ano") Integer ano);

    // @Query("SELECT * FROM EXTRATO s WHERE s.id_conta = ?idConta AND s.mes =
    // ?mes")
    // public List<Extrato> extratoMes(@Param("idConta") Integer
    // idConta,@Param("mes") Integer mes);

}