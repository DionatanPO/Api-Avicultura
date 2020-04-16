package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Pesagem;
import com.example.api_avicultura.repository.PesagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesagemService {

    @Autowired
    PesagemRepository pesagemRepository;

    public Pesagem salvar(Pesagem pesagem) {
        //validações e etcS
        return pesagemRepository.save(pesagem);
    }

    public void delete(Pesagem pesagem) {

        pesagemRepository.delete(pesagem);
    }

    public Pesagem buscaPorID(Long id) throws Exception {
        return pesagemRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return pesagemRepository.findAll();
    }
    public List buscarLote(Lote lote) {
        return pesagemRepository.findByLote_idContaining(String.valueOf(lote.getId()));
    }

}
