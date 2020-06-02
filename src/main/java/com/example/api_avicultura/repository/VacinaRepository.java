package com.example.api_avicultura.repository;

import com.example.api_avicultura.model.Vacina;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

 
 List<Vacina> findByLote_id(Long lote_id);
}
