/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_avicultura.model;

import javax.persistence.CascadeType;
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
public class Lote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne()
    @JoinColumn(name = "proprietario_id")
    private Produtor proprietario;
    
    private Float peso_inicial;
    private Float racao_inicial;
    private int  q_aves_inicial;
    private int  q_aves_final;
    private int  q_aves_abatidas;
    private int  q_aves_mortas;

    public Lote() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produtor getProprietario() {
        return proprietario;
    }

    public void setProprietario(Produtor proprietario) {
        this.proprietario = proprietario;
    }

    public Float getPeso_inicial() {
        return peso_inicial;
    }

    public void setPeso_inicial(Float peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public Float getRacao_inicial() {
        return racao_inicial;
    }

    public void setRacao_inicial(Float racao_inicial) {
        this.racao_inicial = racao_inicial;
    }

    public int getQ_aves_inicial() {
        return q_aves_inicial;
    }

    public void setQ_aves_inicial(int q_aves_inicial) {
        this.q_aves_inicial = q_aves_inicial;
    }

    public int getQ_aves_final() {
        return q_aves_final;
    }

    public void setQ_aves_final(int q_aves_final) {
        this.q_aves_final = q_aves_final;
    }

    public int getQ_aves_abatidas() {
        return q_aves_abatidas;
    }

    public void setQ_aves_abatidas(int q_aves_abatidas) {
        this.q_aves_abatidas = q_aves_abatidas;
    }

    public int getQ_aves_mortas() {
        return q_aves_mortas;
    }

    public void setQ_aves_mortas(int q_aves_mortas) {
        this.q_aves_mortas = q_aves_mortas;
    }
    
    
    
    
    
}
