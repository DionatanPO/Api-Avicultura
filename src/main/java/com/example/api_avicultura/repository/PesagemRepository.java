package com.example.api_avicultura.repository;

import com.example.api_avicultura.model.Pesagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesagemRepository extends JpaRepository<Pesagem, Long> {



}
