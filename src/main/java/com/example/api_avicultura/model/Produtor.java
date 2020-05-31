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
public class Produtor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String nome_propriedade;
    private String cod_identificacao;
    private String senha;

    public Produtor() {
    }

    public String getCod_identificacao() {
        return cod_identificacao;
    }

    public void setCod_identificacao(String cod_identificacao) {
        this.cod_identificacao = cod_identificacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_propriedade() {
        return nome_propriedade;
    }

    public void setNome_propriedade(String nome_propriedade) {
        this.nome_propriedade = nome_propriedade;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
   
    
}
