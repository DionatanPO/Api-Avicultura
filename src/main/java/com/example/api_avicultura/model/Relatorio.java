package com.example.api_avicultura.model;

import java.util.List;

public class Relatorio {
    int qtd_total_ovos_coletado;

    public Relatorio(int qtd_total_ovos_coletado) {
        this.qtd_total_ovos_coletado = qtd_total_ovos_coletado;
    }

    public Relatorio() {
    }

    public int getQtd_total_ovos_coletado() {
        return qtd_total_ovos_coletado;
    }

    public void setQtd_total_ovos_coletado(int qtd_total_ovos_coletado) {
        this.qtd_total_ovos_coletado = qtd_total_ovos_coletado;
    }
    public int calcular_total_ovos(List<Ovo> quantidade){
        int result =0;
        for(int i=0;i<quantidade.size();i++){
            result += +quantidade.get(i).getQuantidade();
        }

        return result;
    }
}
