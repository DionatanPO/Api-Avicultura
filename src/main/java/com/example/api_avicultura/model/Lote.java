/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api_avicultura.model;

import java.sql.Date;
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
    @JoinColumn(name = "produtor_id")
    private Produtor produtor;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "indice_id")
    private Indice indice;
    
    private String tipo;
    private String estado;
    private String identificacao;
    private int peso_inicial;
    private int peso_final;
    private int peso_medio;

    private int racao_inicial;
    private int racao_final;
    private Date data_abertura;
    private Date data_abate;
    private int q_aves_inicial;
    private int q_aves_final;
    private int q_aves_abatidas;
    private int q_aves_mortas;


    public Lote() {
    }

    public String getEstado() {
        return estado;
    }

    public int getPeso_medio() {
        return peso_medio;
    }

    public void setPeso_medio(int peso_medio) {
        this.peso_medio = peso_medio;
    }
    

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Indice getIndice() {
        return indice;
    }

    public void setIndice(Indice indice) {
        this.indice = indice;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getPeso_inicial() {
        return peso_inicial;
    }

    public void setPeso_inicial(int peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public int getPeso_final() {
        return peso_final;
    }

    public void setPeso_final(int peso_final) {
        this.peso_final = peso_final;
    }


    public int getRacao_inicial() {
        return racao_inicial;
    }

    public void setRacao_inicial(int racao_inicial) {
        this.racao_inicial = racao_inicial;
    }

    public int getRacao_final() {
        return racao_final;
    }

    public void setRacao_final(int racao_final) {
        this.racao_final = racao_final;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_abate() {
        return data_abate;
    }

    public void setData_abate(Date data_abate) {
        this.data_abate = data_abate;
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
