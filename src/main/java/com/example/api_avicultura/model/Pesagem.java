package com.example.api_avicultura.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pesagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "lote_id")
    private Lote lote;

    private int n_aves_pesadas;
    private int n_aves_fora_media;
    private int n_aves_dentro_media;
    private Date data_pesagem;
    private double peso_extremo_superior;
    private double peso_extremo_inferior;
    private double variacao_peso_medio;
    private double peso_medio;
    private double uniformidade;

    public Pesagem() {

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

    public int getN_aves_pesadas() {
        return n_aves_pesadas;
    }

    public void setN_aves_pesadas(int n_aves_pesadas) {
        this.n_aves_pesadas = n_aves_pesadas;
    }

    public int getN_aves_fora_media() {
        return n_aves_fora_media;
    }

    public void setN_aves_fora_media(int n_aves_fora_media) {
        this.n_aves_fora_media = n_aves_fora_media;
    }

    public int getN_aves_dentro_media() {
        return n_aves_dentro_media;
    }

    public void setN_aves_dentro_media(int n_aves_dentro_media) {
        this.n_aves_dentro_media = n_aves_dentro_media;
    }

    public Date getData_pesagem() {
        return data_pesagem;
    }

    public void setData_pesagem(Date data_pesagem) {
        this.data_pesagem = data_pesagem;
    }

    public double getPeso_extremo_superior() {
        return peso_extremo_superior;
    }

    public void setPeso_extremo_superior(double peso_extremo_superior) {
        this.peso_extremo_superior = peso_extremo_superior;
    }

    public double getPeso_extremo_inferior() {
        return peso_extremo_inferior;
    }

    public void setPeso_extremo_inferior(double peso_extremo_inferior) {
        this.peso_extremo_inferior = peso_extremo_inferior;
    }

    public double getVariacao_peso_medio() {
        return variacao_peso_medio;
    }

    public void setVariacao_peso_medio(double variacao_peso_medio) {
        this.variacao_peso_medio = variacao_peso_medio;
    }

    public double getPeso_medio() {
        return peso_medio;
    }

    public void setPeso_medio(double peso_medio) {
        this.peso_medio = peso_medio;
    }

    public double getUniformidade() {
        return uniformidade;
    }

    public void setUniformidade(double uniformidade) {
        this.uniformidade = uniformidade;
    }

   
}
