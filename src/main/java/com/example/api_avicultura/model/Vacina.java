/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_avicultura.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Dionatan
 */
@Entity
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne()
    @JoinColumn(name = "lote_id")
    private Lote lote;
    
    private String nome_vacina;
    private String obs;
    private String via_administracao;
    private int n_aves_vacinadas;
    private int idade_dia;
    private int idade_semana;
    private Date data_vacinacao;

    public Vacina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getVia_administracao() {
        return via_administracao;
    }

    public void setVia_administracao(String via_administracao) {
        this.via_administracao = via_administracao;
    }

    public int getN_aves_vacinadas() {
        return n_aves_vacinadas;
    }

    public void setN_aves_vacinadas(int n_aves_vacinadas) {
        this.n_aves_vacinadas = n_aves_vacinadas;
    }

    public int getIdade_dia() {
        return idade_dia;
    }

    public void setIdade_dia(int idade_dia) {
        this.idade_dia = idade_dia;
    }

    public int getIdade_semana() {
        return idade_semana;
    }

    public void setIdade_semana(int idade_semana) {
        this.idade_semana = idade_semana;
    }

    public Date getData_vacinacao() {
        return data_vacinacao;
    }

    public void setData_vacinacao(Date data_vacinacao) {
        this.data_vacinacao = data_vacinacao;
    }
    
    
}
