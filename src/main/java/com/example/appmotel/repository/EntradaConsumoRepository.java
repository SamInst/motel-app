package com.example.appmotel.repository;

import com.example.appmotel.model.EntradaConsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaConsumoRepository extends JpaRepository<EntradaConsumo, Long> {
    List<EntradaConsumo> findEntradaConsumoByEntradas_Id(Long id);
}
