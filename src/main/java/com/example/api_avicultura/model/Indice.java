/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_avicultura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dionatan
 */
@Entity
public class Indice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double uniformidade;
    private double ica;
    private double consumo_ração;
    private double mortalidade;
    private double viabilidade;
    private double fator_producao;
    private double ca_duzia;
    private int qtd_dz;

    public Indice() {
    }

    public Long getId() {
        return id;
    }

    public int getQtd_dz() {
        return qtd_dz;
    }

    public void setQtd_dz(int qtd_dz) {
        this.qtd_dz = qtd_dz;
    }

    public double getCa_duzia() {
        return ca_duzia;
    }

    public void setCa_duzia(double ca_duzia) {
        this.ca_duzia = ca_duzia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getFator_producao() {
        return fator_producao;
    }

    public void setFator_producao(double fator_producao) {
        this.fator_producao = fator_producao;
    }

    public double getUniformidade() {
        return uniformidade;
    }

    public void setUniformidade(double uniformidade) {
        this.uniformidade = uniformidade;
    }

    public double getIca() {
        return ica;
    }

    public void setIca(double ica) {
        this.ica = ica;
    }

    public double getConsumo_ração() {
        return consumo_ração;
    }

    public void setConsumo_ração(double consumo_ração) {
        this.consumo_ração = consumo_ração;
    }

    public double getMortalidade() {
        return mortalidade;
    }

    public void setMortalidade(double mortalidade) {
        this.mortalidade = mortalidade;
    }

    public double getViabilidade() {
        return viabilidade;
    }

    public void setViabilidade(double viabilidade) {
        this.viabilidade = viabilidade;
    }

}
