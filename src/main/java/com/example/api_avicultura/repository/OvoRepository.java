package com.example.api_avicultura.repository;

import com.example.api_avicultura.model.Ovo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvoRepository extends JpaRepository<Ovo, Long> {

 
 List<Ovo> findByLote_id(Long lote_id);
}
