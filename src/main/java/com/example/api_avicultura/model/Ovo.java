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
public class Ovo {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne()
    @JoinColumn(name = "lote_id")
    private Lote lote;
    
    private int quantidade;
    private Date data_coleta;
    private int n_coleta;

    public Ovo() {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData_coleta() {
        return data_coleta;
    }

    public void setData_coleta(Date data_coleta) {
        this.data_coleta = data_coleta;
    }

    public int getN_coleta() {
        return n_coleta;
    }

    public void setN_coleta(int n_coleta) {
        this.n_coleta = n_coleta;
    }
    
    }
