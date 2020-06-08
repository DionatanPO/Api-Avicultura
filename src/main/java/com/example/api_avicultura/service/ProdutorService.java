package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Produtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.api_avicultura.repository.ProdutorRepository;

@Service
public class ProdutorService {

    @Autowired
    ProdutorRepository produtorRepository;

    public Produtor salvar(Produtor produtor) {
        //validações e etcS
        return produtorRepository.save(produtor);
    }

    public void delete(Produtor produtor) {

        produtorRepository.delete(produtor);
    }

    public Produtor buscaPorID(Long id) throws Exception {
        return produtorRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return produtorRepository.findAll();
    }
    
      public Produtor buscaPorCodiidentificacao(String codidentificacao) throws Exception {
        return produtorRepository.findByCodidentificacao(codidentificacao);
    }
    
}
