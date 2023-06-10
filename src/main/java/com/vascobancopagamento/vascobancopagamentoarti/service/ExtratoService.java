package com.vascobancopagamento.vascobancopagamentoarti.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vascobancopagamento.vascobancopagamentoarti.model.Extrato;
import com.vascobancopagamento.vascobancopagamentoarti.repository.ExtratoRepository;

@Service
public class ExtratoService {
    @Autowired
    private ExtratoRepository extratoRepository;

    public List<Extrato> extratoDia(Integer idConta) {
        return List.of(new Extrato());
        // return extratoRepository.extratoDia(idConta,
        // LocalDate.now().getDayOfMonth());

    }

    public List<Extrato> extratoMes(Integer idConta) {
        return List.of(new Extrato());
        // return extratoRepository.extratoMes(idConta,
        // LocalDate.now().getMonthValue());
    }

    public List<Extrato> extratoAno(Integer idConta) {
        return List.of(new Extrato());
        // return extratoRepository.extratoDia(idConta, LocalDate.now().getYear());
    }
}
