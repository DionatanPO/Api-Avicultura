package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Indice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.api_avicultura.repository.IndiceRepository;

@Service
public class IndiceService {

    @Autowired
    IndiceRepository indiceRepository;

    public Indice salvar(Indice indice) {
        //validações e etcS
        return indiceRepository.save(indice);
    }

    public void delete(Indice indice) {

        indiceRepository.delete(indice);
    }

    public Indice buscaPorID(Long id) throws Exception {
        return indiceRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return indiceRepository.findAll();
    }


}
