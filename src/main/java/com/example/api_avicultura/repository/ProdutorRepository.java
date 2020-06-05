package com.example.api_avicultura.repository;

import com.example.api_avicultura.model.Produtor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long> {

   List<Produtor> findByNomeAndCod_identificacao(String nome, String cod_identificacao);

}
