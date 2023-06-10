package com.vascobancopagamento.vascobancopagamentoarti.model;



import com.vascobancopagamento.vascobancopagamentoarti.model.enums.OPERACAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Extrato")
@Getter
@Setter
public class Extrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "extrato_id")
    private Integer id;
    @Column(name = "dia")
    private String dia;
    @Column(name = "mes")
    private String mes;
    @Column(name = "ano")
    private String ano;
    @Enumerated(EnumType.STRING)
    @Column(name = "operacao")
    private OPERACAO operacao;
    @Column(name = "conta_id")
    private Integer idConta;

}
