package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Produtor;
import com.example.api_avicultura.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteService {

    @Autowired
    LoteRepository loteRepository;

    public Lote salvar(Lote lote) {
        return loteRepository.save(lote);
    }

    public void delete(Lote lote) {

        loteRepository.delete(lote);
    }

    public Lote buscaPorID(Long id) throws Exception {
        return loteRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return loteRepository.findAll();
    }
     public List buscarLoteProdutor(Lote lote) {
        return loteRepository.findByProdutor_id(lote.getProprietario().getId());
    }

}
