package com.example.api_avicultura.service;

import com.example.api_avicultura.model.Lote;
import com.example.api_avicultura.model.Vacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.api_avicultura.repository.VacinaRepository;

@Service
public class VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    public Vacina salvar(Vacina vacina) {
        //validações e etcS
        return vacinaRepository.save(vacina);
    }

    public void delete(Vacina vacina) {

        vacinaRepository.delete(vacina);
    }

    public Vacina buscaPorID(Long id) throws Exception {
        return vacinaRepository.findById(id).orElseThrow(Exception::new);
    }

    public List buscarTodos() {
        return vacinaRepository.findAll();
    }

     public List buscarLote(Lote lote) {
        return vacinaRepository.findByLote_id(lote.getId());
    }

}
