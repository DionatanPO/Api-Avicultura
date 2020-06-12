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

    public Indice() {
    }

    public Long getId() {
        return id;
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
