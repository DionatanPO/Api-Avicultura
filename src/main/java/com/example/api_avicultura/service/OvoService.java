package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Ovo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.api_avicultura.repository.OvoRepository;

@Service
public class OvoService {

    @Autowired
    OvoRepository ovoRepository;

    public Ovo salvar(Ovo ovo) {
        //validações e etcS
        return ovoRepository.save(ovo);
    }

    public void delete(Ovo ovo) {

        ovoRepository.delete(ovo);
    }

    public Ovo buscaPorID(Long id) throws Exception {
        return ovoRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return ovoRepository.findAll();
    }

     public List buscarLote(Lote lote) {
        return ovoRepository.findByLote_id(lote.getId());
    }

}
