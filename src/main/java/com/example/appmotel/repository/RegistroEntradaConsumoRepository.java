package com.example.appmotel.repository;


import com.example.appmotel.model.RegistroConsumoEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEntradaConsumoRepository extends JpaRepository<RegistroConsumoEntrada, Long> {
}
