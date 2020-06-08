package com.example.api_avicultura.repository;

import com.example.api_avicultura.model.Lote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {

List<Lote> findByProdutor_id(Long produtor_id);

}
