package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Ovo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.api_avicultura.repository.OvoRepository;

@Service
public class OvoService {

    @Autowired
    OvoRepository produtorRepository;

    public Ovo salvar(Ovo produtor) {
        //validações e etcS
        return produtorRepository.save(produtor);
    }

    public void delete(Ovo produtor) {

        produtorRepository.delete(produtor);
    }

    public Ovo buscaPorID(Long id) throws Exception {
        return produtorRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return produtorRepository.findAll();
    }


}
