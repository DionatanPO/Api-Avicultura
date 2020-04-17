package com.example.api_avicultura.repository;

import com.example.api_avicultura.model.Indice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndiceRepository extends JpaRepository<Indice, Long> {

  

}
