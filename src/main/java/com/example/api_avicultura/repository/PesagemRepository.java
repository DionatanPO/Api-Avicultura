package com.example.api_avicultura.repository;

import com.example.api_avicultura.model.Pesagem;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesagemRepository extends JpaRepository<Pesagem, Long> {

    List<Pesagem> findByLote_id(Long lote_id);


}
